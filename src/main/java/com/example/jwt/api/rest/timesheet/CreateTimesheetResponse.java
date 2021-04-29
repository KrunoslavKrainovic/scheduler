package com.example.jwt.api.rest.timesheet;

public class CreateTimesheetResponse {

    private int id;

  public CreateTimesheetResponse() {
  }

  public CreateTimesheetResponse(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
