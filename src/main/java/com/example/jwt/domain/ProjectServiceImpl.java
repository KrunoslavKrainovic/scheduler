package com.example.jwt.domain;

import com.example.jwt.acces.database.entitiy.Project;
import com.example.jwt.acces.database.repository.ProjectRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

  private ProjectRepository projectRepository;

  private UserService userService;

  public ProjectServiceImpl(ProjectRepository projectRepository, UserService userService) {
    this.projectRepository = projectRepository;
    this.userService = userService;
  }


  @Override
  public List<Project> getAll() {
    return projectRepository.findAll();
  }

  @Override
  public List<Project> getByUsername(String username) {
    return userService.getUserByUsername(username).getProjects();
  }



}
