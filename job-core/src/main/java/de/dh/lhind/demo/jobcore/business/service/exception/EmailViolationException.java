package de.dh.lhind.demo.jobcore.business.service.exception;

import de.dh.lhind.demo.jobcore.business.service.common.constants.MessageConstants;
import de.dh.lhind.demo.jobcore.business.service.exception.common.JobAppException;

public class EmailViolationException extends JobAppException {
    public EmailViolationException() {
        super(MessageConstants.MSG_EMAIL_EXISTS);
    }

    public EmailViolationException(String message) {
        super(MessageConstants.MSG_EMAIL_EXISTS, message);
    }

    public EmailViolationException(String message, Throwable t) {
        super(MessageConstants.MSG_EMAIL_EXISTS, message, t);
    }

    public EmailViolationException(Throwable t) {
        super(MessageConstants.MSG_EMAIL_EXISTS, t);
    }

    protected EmailViolationException(String messageConstant, String message, Throwable t) {
        super(messageConstant, message, t);
    }
}
