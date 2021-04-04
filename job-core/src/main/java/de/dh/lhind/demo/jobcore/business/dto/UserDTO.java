package de.dh.lhind.demo.jobcore.business.dto;

import de.dh.lhind.demo.jobcore.business.common.BaseClassDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseClassDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private RoleDTO role;

}
