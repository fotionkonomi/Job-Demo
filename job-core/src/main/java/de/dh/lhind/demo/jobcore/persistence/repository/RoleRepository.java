package de.dh.lhind.demo.jobcore.persistence.repository;

import de.dh.lhind.demo.jobcore.persistence.entities.Role;
import de.dh.lhind.demo.jobcore.persistence.entities.enums.RoleEnum;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends ParentRepository<Role, Long> {

    Role findByRoleEnum(RoleEnum roleEnum);
}
