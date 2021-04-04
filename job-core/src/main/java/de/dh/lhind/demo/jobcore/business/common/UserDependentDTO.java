package de.dh.lhind.demo.jobcore.business.common;

import de.dh.lhind.demo.jobcore.business.dto.UserDTO;
import lombok.Data;

@Data
public abstract class UserDependentDTO extends BaseClassDTO {
    private UserDTO createdBy;
    private UserDTO updatedBy;
}
