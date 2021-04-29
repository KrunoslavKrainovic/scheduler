package com.example.jwt.domain;

import com.example.jwt.acces.database.entitiy.Project;
import com.example.jwt.acces.database.entitiy.Timesheet;
import com.example.jwt.acces.database.entitiy.User;
import com.example.jwt.acces.database.repository.ProjectRepository;
import com.example.jwt.acces.database.repository.TimesheetRepository;
import com.example.jwt.acces.database.repository.UserRepository;
import com.example.jwt.domain.exception.TimesheetDoesNotExistException;
import com.example.jwt.domain.exception.ProjectIsNotAssignToTimesheetException;
import com.example.jwt.domain.exception.UserIsNotAssignToProjectException;
import com.example.jwt.domain.exception.UserIsNotAssignToTimesheetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TimesheetServiceImpl implements TimesheetService {

  TimesheetRepository timesheetRepository;
  ProjectRepository projectRepository;
  UserRepository userRepository;

  public TimesheetServiceImpl(TimesheetRepository timesheetRepository,
      ProjectRepository projectRepository, UserRepository userRepository) {
    this.timesheetRepository = timesheetRepository;
    this.projectRepository = projectRepository;
    this.userRepository = userRepository;
  }

  @Override
  public List<Timesheet> getTimesheetByUsernameProjectIdAndDate(String username, String year, String month,
      int projectId) {

    List<Timesheet> timesheets = new ArrayList();

    LocalDate initial = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
    LocalDate start = initial.withDayOfMonth(1);
    LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());



    timesheets = timesheetRepository.findByUsernameProjectIdAndDate(username, LocalDateTime.of(start, LocalTime.of(0,0,0)),LocalDateTime.of(end, LocalTime.of(0,0,0)),projectId);

    return timesheets;
  }

  @Override
  public int createTimesheet(Timesheet timesheet, String username, int projectId) {


      User user = userRepository.findByUsername(username);


    if (!user.hasProject(projectId)){
      throw new UserIsNotAssignToProjectException();
    }

    Optional<Project> project = projectRepository.findById(projectId);


   timesheet.setProject(project.get());
   timesheet.setUser(user);

    return timesheetRepository.save(timesheet).getId();

  }

  @Override
  public void editTimesheet(Timesheet timesheet, String username, int projectId) {

    User user = userRepository.findByUsername(username);

    if (!user.hasProject(projectId)){
      throw new UserIsNotAssignToProjectException();
    }


    boolean doesTimesheetExist = timesheetRepository.existsById(timesheet.getId());

    if(!doesTimesheetExist){
      throw new TimesheetDoesNotExistException();
    }

    Timesheet userTimesheet = timesheetRepository.findById(timesheet.getId()).get();

    if(userTimesheet.getProject().getId() != projectId){
      throw new ProjectIsNotAssignToTimesheetException();
    }


    String timesheetUsername = userTimesheet.getUser().getUsername();

     if(!timesheetUsername.equals(username)){
       throw new UserIsNotAssignToTimesheetException();
     }

    timesheet.setUser(user);

     Project userProject = projectRepository.findById(projectId).get();

     timesheet.setProject(userProject);
      timesheetRepository.save(timesheet);


  }

  @Override
  public void deleteTimesheet(int timesheetId, String username, int projectId) {
    User user = userRepository.findByUsername(username);

    if (!user.hasProject(projectId)){
      throw new UserIsNotAssignToProjectException();
    }


    boolean doesTimesheetExist = timesheetRepository.existsById(timesheetId);

    if(!doesTimesheetExist){
      throw new TimesheetDoesNotExistException();
    }

    Timesheet userTimesheet = timesheetRepository.findById(timesheetId).get();

    if(userTimesheet.getProject().getId() != projectId){
      throw new ProjectIsNotAssignToTimesheetException();
    }


    String timesheetUsername = userTimesheet.getUser().getUsername();

    if(!timesheetUsername.equals(username)){
      throw new UserIsNotAssignToTimesheetException();
    }


    timesheetRepository.deleteById(timesheetId);

  }


}
