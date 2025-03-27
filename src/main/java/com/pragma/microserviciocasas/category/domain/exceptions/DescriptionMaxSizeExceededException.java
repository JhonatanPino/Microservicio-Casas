package com.pragma.microserviciocasas.category.domain.exceptions;

public class DescriptionMaxSizeExceededException extends RuntimeException {
    public DescriptionMaxSizeExceededException(String message) {
        super(message);
    }
}
