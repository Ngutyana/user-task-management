package com.restapi.usertaskssystem.repository;

import com.restapi.usertaskssystem.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepo extends JpaRepository<Tasks,Long> {

}
