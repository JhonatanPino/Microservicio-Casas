package com.pragma.microserviciocasas.domain.exceptions;

public class NameMaxSizeExceededException extends RuntimeException {
    public NameMaxSizeExceededException(String message) {
        super(message);
    }
}
