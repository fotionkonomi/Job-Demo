package de.dh.lhind.demo.jobapi.security.service;

import de.dh.lhind.demo.jobapi.security.model.AuthenticationRequest;
import de.dh.lhind.demo.jobapi.security.model.AuthenticationResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
