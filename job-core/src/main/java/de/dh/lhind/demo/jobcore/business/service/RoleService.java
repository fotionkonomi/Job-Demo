package de.dh.lhind.demo.jobcore.business.service;

import de.dh.lhind.demo.jobcore.business.dto.RoleDTO;
import de.dh.lhind.demo.jobcore.business.service.base.BaseService;
import de.dh.lhind.demo.jobcore.persistence.entities.enums.RoleEnum;

public interface RoleService extends BaseService<RoleDTO, Long> {
    RoleDTO getRoleByRoleName(RoleEnum roleEnum);
}
