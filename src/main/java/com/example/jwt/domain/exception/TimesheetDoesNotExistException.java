package com.example.jwt.domain.exception;

public class TimesheetDoesNotExistException extends RuntimeException {


  public TimesheetDoesNotExistException() {
  }

  public TimesheetDoesNotExistException(String message) {
    super(message);
  }

  public TimesheetDoesNotExistException(String message, Throwable cause) {
    super(message, cause);
  }

  public TimesheetDoesNotExistException(Throwable cause) {
    super(cause);
  }

  public TimesheetDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }



}
