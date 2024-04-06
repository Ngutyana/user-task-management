package com.restapi.usertaskssystem.service;

import com.restapi.usertaskssystem.model.Tasks;

import java.util.List;

public interface TasksService
{
    Tasks getTasksById(Long taskID, Long id); //read
    Tasks saveTasks(Long userID, Tasks tasks); //create
    void updateTasks(Tasks tasks); //update
    void deleteTasks(Long taskID, Long id); //delete
    List<Tasks> getAllTasks(Long userID);  //retrieve all tasks by userID

    void updateTaskStatus();



}
