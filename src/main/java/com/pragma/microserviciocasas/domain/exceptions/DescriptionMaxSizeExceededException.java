package com.pragma.microserviciocasas.domain.exceptions;

public class DescriptionMaxSizeExceededException extends RuntimeException {
    public DescriptionMaxSizeExceededException(String message) {
        super(message);
    }
}
