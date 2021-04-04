package de.dh.lhind.demo.jobcore.business.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.dh.lhind.demo.jobcore.business.common.UserDependentDTO;
import de.dh.lhind.demo.jobcore.business.dto.enums.JobType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class JobDTO extends UserDependentDTO {

    private Double minYearsOfExperience;

    @JsonBackReference
    private CompanyDTO hiringCompany;

    private Integer wage;

    private String jobTitle;

    private String description;

    private JobType jobType;

}
