package de.dh.lhind.demo.jobapi.rest.exceptionhandler;

import de.dh.lhind.demo.jobapi.rest.exceptionhandler.model.HttpErrorResponse;
import de.dh.lhind.demo.jobapi.rest.exceptionhandler.util.ExceptionMessageUtil;
import de.dh.lhind.demo.jobapi.security.exception.MyAuthenticationException;
import de.dh.lhind.demo.jobcore.business.service.exception.common.JobAppException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

@ControllerAdvice
@Log4j
public class ExceptionHandler {

    @Autowired
    private ExceptionMessageUtil messageUtil;

    @org.springframework.web.bind.annotation.ExceptionHandler(JobAppException.class)
    public ResponseEntity<HttpErrorResponse> handleServiceExceptions(JobAppException exception, HttpServletRequest request) {
        log.error("Exception from service layer: " + exception);
        return fillHttpErrorResponse(request, messageUtil.getLocalizedMessage(exception.getMessageKey()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<HttpErrorResponse> handleBadCredentialsException(BadCredentialsException exception, HttpServletRequest request) {
        log.error("Exception while trying to log in: " + exception);
        return fillHttpErrorResponse(request, messageUtil.getLocalizedMessage(exception.getMessage()));
    }

    private ResponseEntity<HttpErrorResponse> fillHttpErrorResponse(HttpServletRequest request, String localizedMessage) {
        HttpErrorResponse httpErrorResponse = new HttpErrorResponse();
        httpErrorResponse.setLocalizedMessage(localizedMessage);
        HttpStatus errorStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        httpErrorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        httpErrorResponse.setPath(request.getRequestURI());
        httpErrorResponse.setMessage(errorStatus.getReasonPhrase());
        return ResponseEntity.status(errorStatus).body(httpErrorResponse);
    }

}
