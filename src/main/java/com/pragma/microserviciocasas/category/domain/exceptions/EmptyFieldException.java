package com.pragma.microserviciocasas.category.domain.exceptions;

public class EmptyFieldException extends RuntimeException {
  public EmptyFieldException(String message) {
    super(message);
  }
}
