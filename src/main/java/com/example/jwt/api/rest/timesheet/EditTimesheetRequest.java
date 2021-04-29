package com.example.jwt.api.rest.timesheet;

import java.time.LocalDateTime;

public class EditTimesheetRequest {

  private int id;
  private String description;
  private LocalDateTime startDate;
  private LocalDateTime endDate;

  public EditTimesheetRequest(int id, String description, LocalDateTime startDate, LocalDateTime endDate) {
    this.id = id;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public EditTimesheetRequest() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }
}
