package de.dh.lhind.demo.jobcore.business.service.impl;

import de.dh.lhind.demo.jobcore.business.dto.UserDTO;
import de.dh.lhind.demo.jobcore.business.service.UserService;
import de.dh.lhind.demo.jobcore.business.service.base.AbstractJpaService;
import de.dh.lhind.demo.jobcore.business.service.exception.UserNotFoundException;
import de.dh.lhind.demo.jobcore.persistence.entities.User;
import de.dh.lhind.demo.jobcore.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractJpaService<UserDTO, User, Long> implements UserService {

    public UserServiceImpl() {
        super(User.class, UserDTO.class);
    }

    @Override
    public UserDTO findByEmail(String email) throws UserNotFoundException {
        Optional<User> optionalUser = ((UserRepository) repo).findByEmail(email);
        if(optionalUser.isPresent()) {
            return mapFromEntity(optionalUser.get());
        } else {
            throw new UserNotFoundException();
        }
    }

}
