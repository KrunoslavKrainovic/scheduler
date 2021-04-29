package com.example.jwt.domain.exception;

public class UserIsNotAssignToProjectException extends RuntimeException {

  public UserIsNotAssignToProjectException() {
  }

  public UserIsNotAssignToProjectException(String message) {
    super(message);
  }

  public UserIsNotAssignToProjectException(String message, Throwable cause) {
    super(message, cause);
  }

  public UserIsNotAssignToProjectException(Throwable cause) {
    super(cause);
  }

  public UserIsNotAssignToProjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}