package de.dh.lhind.demo.jobcore.business.common;

import de.dh.lhind.demo.jobcore.business.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDependentDTO extends BaseClassDTO {
    private UserDTO createdBy;
    private UserDTO updatedBy;
}
