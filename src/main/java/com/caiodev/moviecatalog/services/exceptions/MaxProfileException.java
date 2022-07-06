package com.caiodev.moviecatalog.services.exceptions;

public class MaxProfileException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MaxProfileException(String message) {
        super(message);
    }
}
