package de.dh.lhind.demo.jobapi.rest.exceptionhandler.util;

import org.springframework.stereotype.Component;

public interface ExceptionMessageUtil {

    String getLocalizedMessage(String messageKey);
}
