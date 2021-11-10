package org.arsiu.rest.exception.technique.not.found;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(final String message) {
        super(message);
    }

    public ItemNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
