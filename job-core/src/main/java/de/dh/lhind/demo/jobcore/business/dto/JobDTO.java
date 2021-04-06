package de.dh.lhind.demo.jobcore.business.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.dh.lhind.demo.jobcore.business.common.UserDependentDTO;
import de.dh.lhind.demo.jobcore.persistence.entities.enums.JobType;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class JobDTO extends UserDependentDTO {

    private Double minYearsOfExperience;

    @NotNull
    private CompanyDTO hiringCompany;

    private Integer wage;

    private String jobTitle;

    private String description;

    private JobType jobType;

}
