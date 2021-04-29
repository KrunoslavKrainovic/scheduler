package com.example.jwt.acces.database.repository;

import com.example.jwt.acces.database.entitiy.Organization;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  OrganizationRepository extends JpaRepository<Organization,Integer> {

    List<Organization> findByProjectsUsersUsername(String username);

    }
