package com.example.jwt.api.rest.project;

import com.example.jwt.acces.database.entitiy.Timesheet;
import com.example.jwt.acces.database.repository.TimesheetRepository;
import com.example.jwt.domain.ProjectService;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProjectController {

  ProjectService projectService;
  TimesheetRepository organizationRepository;


/*  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }*/

  public ProjectController(ProjectService projectService,
      TimesheetRepository organizationRepository) {
    this.projectService = projectService;
    this.organizationRepository = organizationRepository;
  }

  @GetMapping("/v1/admin/projects")
  public List<ProjectResponse> getAllProjects() {

    List<ProjectResponse> projectResponses;



     projectResponses = projectService.getAll().stream()
        .map(ProjectResponse::new)
        .collect(Collectors.toList());

    return projectResponses;

  }

  @GetMapping("/v1/projects")
  public List<ProjectResponse> getUserProjects(Principal principal) {



    return projectService.getByUsername(principal.getName()).stream()
        .map(ProjectResponse::new)
        .collect(Collectors.toList());



  }

  @GetMapping("/v1/test")
  public List<String> getUserProjects() {



    return null;

  }
}
