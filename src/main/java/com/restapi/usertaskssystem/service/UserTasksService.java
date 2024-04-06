package com.restapi.usertaskssystem.service;

import com.restapi.usertaskssystem.model.UserTasks;
import com.restapi.usertaskssystem.model.Users;

import java.util.List;

public interface UserTasksService {
    void saveUserTasks(UserTasks userTasks);
    List<UserTasks> getUserTasks(Long userID);
    boolean existsByUserIDEqualsAndTaskIDEquals(Long userID, Long taskID);

}
