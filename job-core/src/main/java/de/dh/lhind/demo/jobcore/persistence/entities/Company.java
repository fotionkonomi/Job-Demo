package de.dh.lhind.demo.jobcore.persistence.entities;

import de.dh.lhind.demo.jobcore.persistence.entities.common.UserDependentEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "company")
@SQLDelete(sql = "UPDATE company SET deleted = 1 WHERE ID = ?")
@Where(clause = "deleted <> '1'")
@ToString(onlyExplicitlyIncluded = true)
public class Company extends UserDependentEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "hiringCompany")
    private List<Job> jobs = new ArrayList<>();
}
