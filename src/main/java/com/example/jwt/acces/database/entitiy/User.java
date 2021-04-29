package com.example.jwt.acces.database.entitiy;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String username;
  private String password;
  @ManyToOne(cascade = CascadeType.MERGE)
  private Role role;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "user_project",
      joinColumns = { @JoinColumn(name = "user_id") },
      inverseJoinColumns = { @JoinColumn(name = "project_id") }
  )
  List<Project> projects = new ArrayList<>();

  public User(String username, String password, Role role) {
    this.username = username;
    this.password = password;
    this.role = role;

  }

  public User(String username, String password, Role role,
      List<Project> projects) {
    this.username = username;
    this.password = password;
    this.role = role;
    this.projects = projects;
  }



  public User() {
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

  public boolean hasProject(int idToCheck){

    boolean idExists = getProjects().stream()
        .anyMatch(t -> t.getId() == idToCheck);

    return idExists;

  }




}
