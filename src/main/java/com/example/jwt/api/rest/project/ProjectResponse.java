package com.example.jwt.api.rest.project;

import com.example.jwt.acces.database.entitiy.Project;

public class ProjectResponse {

  private String id;

  private String name;

  public ProjectResponse(Project project) {
    this.id = String.valueOf(project.getId());
    this.name = project.getName();
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
