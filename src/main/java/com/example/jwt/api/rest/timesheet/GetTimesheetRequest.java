package com.example.jwt.api.rest.timesheet;

public class GetTimesheetRequest {

  private String year;
  private String month;

  public GetTimesheetRequest(String year, String month) {
    this.year = year;
    this.month = month;
  }

  public GetTimesheetRequest() {
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }
}
