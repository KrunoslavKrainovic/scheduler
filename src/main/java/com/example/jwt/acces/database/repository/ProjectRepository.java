package com.example.jwt.acces.database.repository;

import com.example.jwt.acces.database.entitiy.Project;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {

  Project findByName(String name);



}
