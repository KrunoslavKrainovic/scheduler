package com.example.jwt.api.rest.timesheet;

public class DeleteTimesheetRequest {

  int id;

  public DeleteTimesheetRequest(int id) {
    this.id = id;
  }

  public DeleteTimesheetRequest() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
