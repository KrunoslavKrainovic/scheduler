package com.example.jwt.domain.exception;

public class AccountAlreadyExistException extends RuntimeException {

  public AccountAlreadyExistException() {
  }

  public AccountAlreadyExistException(String message) {
    super(message);
  }

  public AccountAlreadyExistException(String message, Throwable cause) {
    super(message, cause);
  }

  public AccountAlreadyExistException(Throwable cause) {
    super(cause);
  }

  public AccountAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
