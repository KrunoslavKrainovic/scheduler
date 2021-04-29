package com.example.jwt.api.rest.timesheet;

import com.example.jwt.acces.database.entitiy.Timesheet;
import com.example.jwt.domain.TimesheetService;
import com.example.jwt.domain.exception.ProjectIsNotAssignToTimesheetException;
import com.example.jwt.domain.exception.TimesheetDoesNotExistException;
import com.example.jwt.domain.exception.UserIsNotAssignToProjectException;
import com.example.jwt.domain.exception.UserIsNotAssignToTimesheetException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TimesheetController {

  TimesheetService timesheetService;

  public TimesheetController(TimesheetService timesheetService) {
    this.timesheetService = timesheetService;
  }

  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  @ExceptionHandler(UserIsNotAssignToProjectException.class)
  public String userIsNotAssignedToProject() {
    return "User is not assinged to project";
  }

  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  @ExceptionHandler(UserIsNotAssignToTimesheetException.class)
  public String userIsNotAssignedToTimesheet() {
    return "User is not assinged to timesheet";
  }

  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  @ExceptionHandler(ProjectIsNotAssignToTimesheetException.class)
  public String projectIsNotAssignToTimesheet() {
    return "Project is not assinged to timesheet";
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(TimesheetDoesNotExistException.class)
  public String timesheetDoesNotExist() {
    return "Timesheet does not exist";
  }

  @GetMapping("/v1/timesheet/project/{id}")
  public List<GetTimesheetResponse> getProjectTimesheet(@PathVariable String id, Principal principal, @RequestBody GetTimesheetRequest getTimesheetRequest) {
//TODO: provjeri dali je user assign to project


    return timesheetService.getTimesheetByUsernameProjectIdAndDate(principal.getName(), getTimesheetRequest.getYear(),
        getTimesheetRequest.getMonth(),Integer.parseInt(id)).stream()
        .map(GetTimesheetResponse::new)
        .collect(Collectors.toList());

  }


  @PutMapping("/v1/timesheet/project/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void editProjectTimesheet(@PathVariable String id, Principal principal, @RequestBody EditTimesheetRequest editTimesheetRequest) {

    timesheetService.editTimesheet(new Timesheet(editTimesheetRequest.getStartDate(),editTimesheetRequest.getEndDate(),editTimesheetRequest.getDescription(),editTimesheetRequest.getId()),principal.getName(),Integer.parseInt(id));


  }


  @PostMapping("/v1/timesheet/project/{id}")
  public CreateTimesheetResponse createProjectTimesheet(@PathVariable String id, Principal principal, @RequestBody CreateTimesheetRequest createTimesheetRequest) {

    int timesheetId= timesheetService.createTimesheet(new Timesheet(createTimesheetRequest.getStartDate(),createTimesheetRequest.getEndDate(),createTimesheetRequest.getDescription()),principal.getName(),Integer.parseInt(id));

    return new CreateTimesheetResponse(timesheetId);

  }

  @DeleteMapping("/v1/timesheet/project/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void deleteProjectTimesheet(@PathVariable String id, Principal principal, @RequestBody DeleteTimesheetRequest deleteTimesheetRequest) {

   timesheetService.deleteTimesheet(deleteTimesheetRequest.getId(),principal.getName(),Integer.parseInt(id));



  }

}
