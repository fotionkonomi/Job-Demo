package de.dh.lhind.demo.jobcore.business.service.impl;

import de.dh.lhind.demo.jobcore.business.dto.RoleDTO;
import de.dh.lhind.demo.jobcore.business.dto.UserDTO;
import de.dh.lhind.demo.jobcore.business.service.RoleService;
import de.dh.lhind.demo.jobcore.business.service.UserService;
import de.dh.lhind.demo.jobcore.business.service.base.AbstractJpaService;
import de.dh.lhind.demo.jobcore.business.service.common.ActionEnum;
import de.dh.lhind.demo.jobcore.business.service.exception.EmailViolationException;
import de.dh.lhind.demo.jobcore.business.service.exception.UserNotFoundException;
import de.dh.lhind.demo.jobcore.persistence.entities.User;
import de.dh.lhind.demo.jobcore.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractJpaService<UserDTO, User, Long> implements UserService {

    @Autowired
    private RoleService roleService;

    public UserServiceImpl() {
        super(User.class, UserDTO.class);
    }

    @Override
    public UserDTO findByEmail(String email) throws UserNotFoundException {
        UserDTO userDTO = findByEmailOrNull(email);
        if(userDTO != null) {
            return userDTO;
        }
        throw new UserNotFoundException();
    }

    @Override
    public UserDTO save(UserDTO dto) {
        if(dto.getId() == null) {
            UserDTO existingUser = this.findByEmailOrNull(dto.getEmail());
            if(existingUser != null) {
                throw new EmailViolationException();
            }
        }

        RoleDTO roleDTO = dto.getRole();
        roleDTO = roleService.getRoleByRoleName(roleDTO.getRole());
        dto.setRole(roleDTO);
        return super.save(dto);
    }

    private UserDTO findByEmailOrNull(String email) {
        Optional<User> optionalUser = ((UserRepository) repo).findByEmail(email);
        if(optionalUser.isPresent()) {
            return mapFromEntity(optionalUser.get());
        } else {
            return null;
        }
    }
}
