package de.dh.lhind.demo.jobcore.persistence.entities;

import de.dh.lhind.demo.jobcore.persistence.entities.common.BaseClass;
import de.dh.lhind.demo.jobcore.persistence.entities.enums.RoleEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "role")
@SQLDelete(sql = "UPDATE role SET deleted = 1 WHERE Id = ?")
@Where(clause = "deleted <> 1")
public class Role extends BaseClass {
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

}
