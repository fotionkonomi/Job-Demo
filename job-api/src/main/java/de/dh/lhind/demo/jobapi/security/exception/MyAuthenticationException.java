package de.dh.lhind.demo.jobapi.security.exception;

import org.springframework.security.core.AuthenticationException;

public class MyAuthenticationException extends AuthenticationException {
    public MyAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public MyAuthenticationException(String msg) {
        super(msg);
    }
}
