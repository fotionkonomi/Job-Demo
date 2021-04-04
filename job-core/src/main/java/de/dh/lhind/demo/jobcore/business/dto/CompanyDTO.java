package de.dh.lhind.demo.jobcore.business.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.dh.lhind.demo.jobcore.business.common.UserDependentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CompanyDTO extends UserDependentDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @JsonManagedReference
    private List<JobDTO> jobs = new ArrayList<>();
}
