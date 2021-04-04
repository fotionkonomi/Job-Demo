package de.dh.lhind.demo.jobcore.business.service.exception;

import de.dh.lhind.demo.jobcore.business.service.constants.MessageConstants;
import de.dh.lhind.demo.jobcore.business.service.exception.common.JobAppException;

public class NoElementFoundException extends JobAppException {
    public NoElementFoundException() {
        super(MessageConstants.MSG_NO_ELEMENT_FOUND_EXCEPTION);
    }

    public NoElementFoundException(String message) {
        super(MessageConstants.MSG_NO_ELEMENT_FOUND_EXCEPTION, message);
    }

    public NoElementFoundException(String message, Throwable t) {
        super(MessageConstants.MSG_NO_ELEMENT_FOUND_EXCEPTION, message, t);
    }

    public NoElementFoundException(Throwable t) {
        super(MessageConstants.MSG_NO_ELEMENT_FOUND_EXCEPTION, t);
    }

    protected NoElementFoundException(String messageConstant, String message, Throwable t) {
        super(messageConstant, message, t);
    }
}
