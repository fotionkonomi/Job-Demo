package de.dh.lhind.demo.jobcore.business.service.exception.common;

import lombok.Getter;
import lombok.Setter;

public abstract class JobAppException extends RuntimeException {

    @Getter
    @Setter
    private String messageKey;

    public JobAppException(String messageKey) {
        this(messageKey, "");
    }

    public JobAppException(String messageKey, String message) {
        this(messageKey, message, null);
    }

    public JobAppException(String messageKey, String message, Throwable t) {
        super(message, t);
        this.messageKey = messageKey;
    }

    public JobAppException(String messageKey, Throwable t) {
        super(t);
        this.messageKey = messageKey;
    }
}
