package com.restapi.usertaskssystem.service;

import com.restapi.usertaskssystem.model.Tasks;

import java.util.List;

public interface TasksService
{   Tasks getTasksById(Long taskID); //read
    Tasks saveTasks(Tasks tasks); //create
    void updateTasks(Tasks tasks); //update
    void deleteTasks(Long taskID, Long id); //delete
    List<Tasks> getAllTasks(Long userID);  //retrieve all tasks by userID

    Tasks findById(Long taskID);

    void updateTaskStatus();
}
