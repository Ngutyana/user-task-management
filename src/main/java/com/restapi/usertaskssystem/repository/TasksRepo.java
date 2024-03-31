package com.restapi.usertaskssystem.repository;

import com.restapi.usertaskssystem.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TasksRepo extends JpaRepository<Tasks,Long> {

    /*List<Tasks> findByStatusAndDateTimeBefore(String status, LocalDateTime dateTime);*/
}
