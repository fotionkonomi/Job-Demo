package de.dh.lhind.demo.jobapi.security.exception;

import de.dh.lhind.demo.jobapi.security.constant.SecurityConstants;
import org.springframework.security.authentication.BadCredentialsException;

public class MyBadCredentialsException extends BadCredentialsException {

    public MyBadCredentialsException() {
        super(SecurityConstants.BAD_CREDENTIALS_EXCEPTION);
    }

    public MyBadCredentialsException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
