package com.pragma.microserviciocasas.category.domain.exceptions;

public class NameMaxSizeExceededException extends RuntimeException {
    public NameMaxSizeExceededException(String message) {
        super(message);
    }
}
