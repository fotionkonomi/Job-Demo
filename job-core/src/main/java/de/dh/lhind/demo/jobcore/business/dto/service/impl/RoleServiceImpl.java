package de.dh.lhind.demo.jobcore.business.dto.service.impl;

import de.dh.lhind.demo.jobcore.business.dto.RoleDTO;
import de.dh.lhind.demo.jobcore.business.dto.service.base.AbstractJpaService;
import de.dh.lhind.demo.jobcore.business.dto.service.base.BaseService;
import de.dh.lhind.demo.jobcore.persistence.entities.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractJpaService<RoleDTO, Role, Long> implements BaseService<RoleDTO, Long> {

    public RoleServiceImpl() {
        super(Role.class, RoleDTO.class);
    }
}
