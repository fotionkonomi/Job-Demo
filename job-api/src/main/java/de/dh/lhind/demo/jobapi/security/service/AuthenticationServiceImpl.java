package de.dh.lhind.demo.jobapi.security.service;

import de.dh.lhind.demo.jobapi.security.exception.MyBadCredentialsException;
import de.dh.lhind.demo.jobapi.security.model.AuthenticationRequest;
import de.dh.lhind.demo.jobapi.security.model.AuthenticationResponse;
import de.dh.lhind.demo.jobapi.security.userdetails.MyUserDetails;
import de.dh.lhind.demo.jobapi.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            return new AuthenticationResponse(jwtUtil.generateToken((MyUserDetails) userDetails));
        } catch(BadCredentialsException e) {
            throw new MyBadCredentialsException();
        }
    }
}

