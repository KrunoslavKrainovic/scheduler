package com.example.jwt.domain;

import com.example.jwt.acces.database.entitiy.Project;
import java.util.List;

public interface ProjectService {

  List<Project> getAll();

  List<Project> getByUsername(String username);

}
