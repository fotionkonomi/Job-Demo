package de.dh.lhind.demo.jobapi.rest.controller;

import de.dh.lhind.demo.jobapi.rest.controller.common.CommonCrudRestController;
import de.dh.lhind.demo.jobapi.security.userdetails.MyUserDetails;
import de.dh.lhind.demo.jobcore.business.dto.CompanyDTO;
import de.dh.lhind.demo.jobcore.business.dto.UserDTO;
import de.dh.lhind.demo.jobcore.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/company")
public class CompanyController extends CommonCrudRestController<CompanyDTO, Long> {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<Void> createObject(@RequestBody CompanyDTO dto) throws URISyntaxException {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDTO userDTO = userService.findByEmail(userDetails.getEmail());
        dto.setCreatedBy(userDTO);
        dto.setUpdatedBy(userDTO);
        return super.createObject(dto);
    }
}
