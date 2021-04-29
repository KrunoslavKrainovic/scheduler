package com.example.jwt.acces.database.entitiy;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Organization {

  @Id
  @GeneratedValue
  private int id;
  private String name;
  @OneToMany(mappedBy="organization")
  private List<Project> projects = new ArrayList();

  public Organization(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Organization(int id, String name, List<Project> projects) {
    this.id = id;
    this.name = name;
    this.projects = projects;
  }

  public Organization() {
  }

  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
