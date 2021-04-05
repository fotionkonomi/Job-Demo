package de.dh.lhind.demo.jobapi.security.exception.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dh.lhind.demo.jobapi.rest.exceptionhandler.model.HttpErrorResponse;
import de.dh.lhind.demo.jobapi.rest.exceptionhandler.util.ExceptionMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ExceptionMessageUtil messageUtil;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        HttpErrorResponse httpErrorResponse = new HttpErrorResponse();
        httpErrorResponse.setErrorCode(HttpServletResponse.SC_UNAUTHORIZED);
        httpErrorResponse.setPath(httpServletRequest.getRequestURI());
        httpErrorResponse.setMessage("Authorization Error: " + messageUtil.getLocalizedMessage(e.getMessage()));
        httpServletResponse.setStatus(httpErrorResponse.getErrorCode());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        objectMapper.writeValue(httpServletResponse.getWriter(), httpErrorResponse);
    }
}
