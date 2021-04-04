package de.dh.lhind.demo.jobapi.rest.exceptionhandler;

import lombok.Data;

import java.util.Date;

@Data
public class HttpErrorResponse {
    private int errorCode;
    private Date timestamp;
    private String path;
    private String message;

    public HttpErrorResponse() {
        this.timestamp = new Date();
    }
}
