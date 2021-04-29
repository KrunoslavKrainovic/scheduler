package com.example.jwt.domain;

import com.example.jwt.acces.database.entitiy.Timesheet;
import com.example.jwt.api.rest.timesheet.CreateTimesheetRequest;
import java.security.Principal;
import java.util.List;

public interface TimesheetService {

  List<Timesheet> getTimesheetByUsernameProjectIdAndDate(String username,String year,String month,int projectId);

  int createTimesheet(Timesheet timesheet, String username, int projectId);

  void editTimesheet(Timesheet timesheet, String username, int projectId);

  void deleteTimesheet(int timesheetId, String name, int projectId);
}
