package de.dh.lhind.demo.jobapi.rest.exceptionhandler.model;

import de.dh.lhind.demo.jobapi.rest.exceptionhandler.HttpErrorResponse;
import de.dh.lhind.demo.jobcore.business.service.exception.common.JobAppException;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Log4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(JobAppException.class)
    public ResponseEntity<HttpErrorResponse> handleServiceExceptions(JobAppException exception, HttpServletRequest request) {
        log.error("Exception from service layer: " + exception);
        HttpStatus errorStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        HttpErrorResponse httpErrorResponse = new HttpErrorResponse();
        httpErrorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        httpErrorResponse.setPath(request.getRequestURI());
        httpErrorResponse.setMessage(errorStatus.getReasonPhrase());
        return ResponseEntity.status(errorStatus).body(httpErrorResponse);
    }
}
