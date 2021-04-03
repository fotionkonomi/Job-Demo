package de.dh.lhind.demo.jobcore.business.dto;

import de.dh.lhind.demo.jobcore.business.dto.common.BaseClassDTO;
import de.dh.lhind.demo.jobcore.business.dto.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleDTO extends BaseClassDTO {
    private RoleEnum role;
}
