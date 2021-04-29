package com.example.jwt.acces.database.entitiy;


import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Timesheet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private String description;

  @ManyToOne(cascade = CascadeType.MERGE)

  private Project project;


  @ManyToOne(cascade = CascadeType.MERGE)
  private User user;

  public Timesheet() {
  }
  public Timesheet( LocalDateTime startDate, LocalDateTime endDate, String description) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.description = description;

  }
  public Timesheet( LocalDateTime startDate, LocalDateTime endDate, String description,int id) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.description = description;
    this.id = id;

  }

  public Timesheet( LocalDateTime startDate, LocalDateTime endDate, String description,
      Project project, User user) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.description = description;
    this.project = project;
    this.user = user;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
