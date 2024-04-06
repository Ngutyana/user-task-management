package com.restapi.usertaskssystem.repository;

import com.restapi.usertaskssystem.model.UserTasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTasksRepo extends JpaRepository<UserTasks, Long> {
    List<UserTasks> findAllByUserIDEquals(Long userID);
    Boolean existsByUserIDEqualsAndTaskIDEquals(Long userID, Long taskID);
}
