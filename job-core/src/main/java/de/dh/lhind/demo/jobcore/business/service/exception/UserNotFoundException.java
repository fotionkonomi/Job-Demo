package de.dh.lhind.demo.jobcore.business.service.exception;

import de.dh.lhind.demo.jobcore.business.service.constants.MessageConstants;
import de.dh.lhind.demo.jobcore.business.service.exception.common.JobAppException;

public class UserNotFoundException extends JobAppException {
    public UserNotFoundException() {
        super(MessageConstants.MSG_USER_NOT_FOUND_EXCEPTION);
    }

    public UserNotFoundException(String message) {
        super(MessageConstants.MSG_USER_NOT_FOUND_EXCEPTION, message);
    }

    public UserNotFoundException(String message, Throwable t) {
        super(MessageConstants.MSG_USER_NOT_FOUND_EXCEPTION, message, t);
    }

    public UserNotFoundException(Throwable t) {
        super(MessageConstants.MSG_USER_NOT_FOUND_EXCEPTION, t);
    }

    protected UserNotFoundException(String messageConstant, String message, Throwable t) {
        super(messageConstant, message, t);
    }
}
