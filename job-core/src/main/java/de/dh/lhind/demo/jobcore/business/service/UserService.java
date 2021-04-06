package de.dh.lhind.demo.jobcore.business.service;

import de.dh.lhind.demo.jobcore.business.dto.UserDTO;
import de.dh.lhind.demo.jobcore.business.service.base.BaseService;
import de.dh.lhind.demo.jobcore.business.service.common.ActionEnum;
import de.dh.lhind.demo.jobcore.business.service.exception.UserNotFoundException;

public interface UserService extends BaseService<UserDTO, Long> {
    UserDTO findByEmail(final String email) throws UserNotFoundException;
}
