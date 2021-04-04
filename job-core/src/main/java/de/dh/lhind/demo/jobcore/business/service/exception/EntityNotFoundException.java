package de.dh.lhind.demo.jobcore.business.service.exception;

import de.dh.lhind.demo.jobcore.business.service.constants.MessageConstants;
import de.dh.lhind.demo.jobcore.business.service.exception.common.JobAppException;

public class EntityNotFoundException extends JobAppException {
    public EntityNotFoundException() {
        super(MessageConstants.MSG_ENTITY_NOT_FOUND_EXCEPTION);
    }

    public EntityNotFoundException(String message) {
        super(MessageConstants.MSG_ENTITY_NOT_FOUND_EXCEPTION, message);
    }

    public EntityNotFoundException(String message, Throwable t) {
        super(MessageConstants.MSG_ENTITY_NOT_FOUND_EXCEPTION, message, t);
    }

    public EntityNotFoundException(Throwable t) {
        super(MessageConstants.MSG_ENTITY_NOT_FOUND_EXCEPTION, t);
    }

    protected EntityNotFoundException(String messageConstant, String message, Throwable t) {
        super(messageConstant, message, t);
    }
}
