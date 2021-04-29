package com.example.jwt.api.rest.timesheet;

import com.example.jwt.acces.database.entitiy.Timesheet;
import java.time.LocalDateTime;

public class GetTimesheetResponse {

  private int id;
  private String description;
  private LocalDateTime startDate;
  private LocalDateTime endDate;

  public GetTimesheetResponse(Timesheet timesheet) {
    this.id = timesheet.getId();
    this.description = timesheet.getDescription();
    this.startDate = timesheet.getStartDate();
    this.endDate = timesheet.getEndDate();
  }

  public GetTimesheetResponse() {
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
