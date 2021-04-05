package de.dh.lhind.demo.jobapi.rest.controller;

import de.dh.lhind.demo.jobapi.security.model.AuthenticationRequest;
import de.dh.lhind.demo.jobapi.security.model.AuthenticationResponse;
import de.dh.lhind.demo.jobapi.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @Autowired
    private AuthenticationService service;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> loginRequest(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(service.authenticate(authenticationRequest));
    }
}
