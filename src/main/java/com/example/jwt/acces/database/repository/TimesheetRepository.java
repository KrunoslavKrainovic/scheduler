package com.example.jwt.acces.database.repository;

import com.example.jwt.acces.database.entitiy.Timesheet;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimesheetRepository extends JpaRepository<Timesheet,Integer> {


    List<Timesheet> findByProjectIdAndUserUsername(int id, String username);

  /*@Query(value = "SELECT * FROM timesheet WHERE start_date Like %:start_date% AND user_id=id" , nativeQuery = true)
  List<Timesheet> findByMatchMonth(@Param("start_date,user_id") String start_date, String user_id);*/

  @Query("select t,u from Timesheet t inner join t.user u where u.username = :username and t.startDate between :startDate and :endDate and t.project.id=:project_id")
  List<Timesheet> findByUsernameProjectIdAndDate(@Param("username") String username, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("project_id") int project_id);
}
