package de.dh.lhind.demo.jobapi.security;

import de.dh.lhind.demo.jobapi.security.constant.SecurityConstants;
import de.dh.lhind.demo.jobapi.security.exception.MyAuthenticationException;
import de.dh.lhind.demo.jobapi.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationFailureHandler authFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            final String authorizationHeader = request.getHeader(SecurityConstants.AUTHORIZAION_HEADER);
            String username = null;
            String jwtToken = null;

            if (authorizationHeader != null && authorizationHeader.startsWith(SecurityConstants.SCHEMA)) {
                jwtToken = authorizationHeader.substring(7);
                UserDetails userDetailsExtractedByToken = jwtUtil.extractUserFromToken(jwtToken);
                username = userDetailsExtractedByToken.getUsername();

            }
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                if (jwtUtil.validateToken(jwtToken, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            filterChain.doFilter(request, response);

        } catch(AuthenticationException e) {
            SecurityContextHolder.clearContext();
            authFailureHandler.onAuthenticationFailure(request, response, e);
        }
    }
}
