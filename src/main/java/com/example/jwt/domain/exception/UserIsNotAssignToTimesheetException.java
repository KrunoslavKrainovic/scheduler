package com.example.jwt.domain.exception;

public class UserIsNotAssignToTimesheetException extends RuntimeException {


  public UserIsNotAssignToTimesheetException() {
  }

  public UserIsNotAssignToTimesheetException(String message) {
    super(message);
  }

  public UserIsNotAssignToTimesheetException(String message, Throwable cause) {
    super(message, cause);
  }

  public UserIsNotAssignToTimesheetException(Throwable cause) {
    super(cause);
  }

  public UserIsNotAssignToTimesheetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }



}
