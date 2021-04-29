package com.example.jwt.domain.exception;

public class ProjectIsNotAssignToTimesheetException extends RuntimeException {

  public ProjectIsNotAssignToTimesheetException() {
  }

  public ProjectIsNotAssignToTimesheetException(String message) {
    super(message);
  }

  public ProjectIsNotAssignToTimesheetException(String message, Throwable cause) {
    super(message, cause);
  }

  public ProjectIsNotAssignToTimesheetException(Throwable cause) {
    super(cause);
  }

  public ProjectIsNotAssignToTimesheetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
