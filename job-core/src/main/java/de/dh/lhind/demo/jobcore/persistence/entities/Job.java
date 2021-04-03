package de.dh.lhind.demo.jobcore.persistence.entities;

import de.dh.lhind.demo.jobcore.persistence.entities.common.UserDependentEntity;
import de.dh.lhind.demo.jobcore.persistence.entities.enums.JobType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "job")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE job SET deleted = 1 WHERE ID = ?")
@Where(clause = "deleted <> '1'")
@ToString(onlyExplicitlyIncluded = true)
public class Job extends UserDependentEntity {

    @Column(name = "min_years_of_experience", nullable = false)
    private Double minYearsOfExperience;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hiring_company_id")
    private Company hiringCompany;

    /**
     * Not using annotations because they are not needed, since wage can be null
     */
    private Integer wage;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "job_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private JobType jobType;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(name = "user_jobs", joinColumns = { @JoinColumn(name = "id_job") },
            inverseJoinColumns = { @JoinColumn(name = "id_user")})
    private Set<User> appliedUsers = new HashSet<>();
}
