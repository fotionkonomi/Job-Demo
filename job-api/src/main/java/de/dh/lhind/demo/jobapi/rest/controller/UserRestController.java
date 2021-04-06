package de.dh.lhind.demo.jobapi.rest.controller;

import de.dh.lhind.demo.jobapi.rest.controller.common.CommonCrudRestController;
import de.dh.lhind.demo.jobapi.rest.utils.Utils;
import de.dh.lhind.demo.jobcore.business.dto.UserDTO;
import de.dh.lhind.demo.jobcore.business.service.UserService;
import de.dh.lhind.demo.jobcore.business.service.common.ActionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/user")
public class UserRestController extends CommonCrudRestController<UserDTO, Long> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<Void> createObject(@RequestBody UserDTO dto) throws URISyntaxException {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        dto = ((UserService)service).save(dto, ActionEnum.CREATE);
        return ResponseEntity.created(Utils.getUriAfterPost(dto)).build();
    }

    @PostMapping("/email")
    public UserDTO findUserByEmail(@RequestBody String email) {
        return ((UserService) service).findByEmail(email);
    }
}
