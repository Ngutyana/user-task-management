package com.restapi.usertaskssystem.service;

import com.restapi.usertaskssystem.model.Tasks;

import java.util.List;

public interface TasksService
{
    Tasks getTasksById(Long taskID, Long id); //read
    void saveTasks(Tasks tasks); //create
    void updateTasks(Tasks tasks); //update
    void deleteTasks(Long taskID, Long id); //delete

    /*void updateTasksStatus();*/

    List<Tasks> getAllTasks(Long userID);  //retrieve all tasks

    Tasks addTasks(Long userID, Tasks tasks);



}
