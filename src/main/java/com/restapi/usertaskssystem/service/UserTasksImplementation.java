package com.restapi.usertaskssystem.service;


import com.restapi.usertaskssystem.model.UserTasks;
import com.restapi.usertaskssystem.repository.UserTasksRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTasksImplementation implements  UserTasksService{

    private final UserTasksRepo userTasksRepo;

    @Override
    public void saveUserTasks(UserTasks userTasks) {
         userTasksRepo.save(userTasks);
    }

    @Override
    public List<UserTasks> getUserTasks(Long userID) {
        return userTasksRepo.findAllByUserIDEquals(userID);
    }

    @Override
    public boolean existsByUserIDEqualsAndTaskIDEquals(Long userID, Long taskID) {
        return userTasksRepo.existsByUserIDEqualsAndTaskIDEquals(userID, taskID);
    }

}
