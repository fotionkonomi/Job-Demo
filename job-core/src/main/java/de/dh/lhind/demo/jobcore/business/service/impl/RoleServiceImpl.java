package de.dh.lhind.demo.jobcore.business.service.impl;

import de.dh.lhind.demo.jobcore.business.dto.RoleDTO;
import de.dh.lhind.demo.jobcore.business.service.RoleService;
import de.dh.lhind.demo.jobcore.business.service.base.AbstractJpaService;
import de.dh.lhind.demo.jobcore.persistence.entities.Role;
import de.dh.lhind.demo.jobcore.persistence.entities.enums.RoleEnum;
import de.dh.lhind.demo.jobcore.persistence.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractJpaService<RoleDTO, Role, Long> implements RoleService {

    public RoleServiceImpl() {
        super(Role.class, RoleDTO.class);
    }

    @Override
    public RoleDTO getRoleByRoleName(RoleEnum roleEnum) {
        return mapFromEntity(((RoleRepository) repo).findRoleByRole(roleEnum));
    }
}
