package de.dh.lhind.demo.jobcore.business.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.dh.lhind.demo.jobcore.business.common.UserDependentDTO;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "jobs")
public class CompanyDTO extends UserDependentDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @JsonIgnore
    private List<JobDTO> jobs = new ArrayList<>();
}
