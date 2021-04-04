package de.dh.lhind.demo.jobcore.business.dto.service.exception;

import de.dh.lhind.demo.jobcore.business.dto.service.constants.MessageConstants;
import de.dh.lhind.demo.jobcore.business.dto.service.exception.common.JobAppException;

public class ConstraintException extends JobAppException {

    public ConstraintException() {
        super(MessageConstants.MSG_CONSTRAINT_EXCEPTION);
    }

    public ConstraintException(String message) {
        super(MessageConstants.MSG_CONSTRAINT_EXCEPTION, message);
    }

    public ConstraintException(String message, Throwable t) {
        super(MessageConstants.MSG_CONSTRAINT_EXCEPTION, message, t);
    }

    public ConstraintException(Throwable t) {
        super(MessageConstants.MSG_CONSTRAINT_EXCEPTION, t);
    }

    protected ConstraintException(String messageConstant, String message, Throwable t) {
        super(messageConstant, message, t);
    }
}
