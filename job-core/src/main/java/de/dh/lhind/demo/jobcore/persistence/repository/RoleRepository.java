package de.dh.lhind.demo.jobcore.persistence.repository;

import de.dh.lhind.demo.jobcore.persistence.entities.Role;
import de.dh.lhind.demo.jobcore.persistence.entities.enums.RoleEnum;

public interface RoleRepository extends ParentRepository<Role, Long> {

    Role findRoleByRole(RoleEnum roleEnum);
}
