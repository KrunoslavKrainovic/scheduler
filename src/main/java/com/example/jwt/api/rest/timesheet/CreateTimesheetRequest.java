package com.example.jwt.api.rest.timesheet;

import com.example.jwt.acces.database.entitiy.Timesheet;
import java.time.LocalDateTime;

public class CreateTimesheetRequest {


  private String description;
  private LocalDateTime startDate;
  private LocalDateTime endDate;

  public CreateTimesheetRequest( String description, LocalDateTime startDate, LocalDateTime endDate) {

    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public CreateTimesheetRequest() {
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
