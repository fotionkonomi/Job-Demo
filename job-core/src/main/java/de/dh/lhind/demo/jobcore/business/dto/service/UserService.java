package de.dh.lhind.demo.jobcore.business.dto.service;

import de.dh.lhind.demo.jobcore.business.dto.UserDTO;
import de.dh.lhind.demo.jobcore.business.dto.service.base.BaseService;

public interface UserService extends BaseService<UserDTO, Long> {
    UserDTO findByEmail(final String email);
}
