package com.restapi.usertaskssystem.service;

import com.restapi.usertaskssystem.model.Tasks;

import java.util.List;

public interface TasksService //extends UsersService
{
    Tasks getTasksById(Long taskID); //read
    void saveTasks(Tasks tasks); //create
    void updateTasks(Tasks tasks); //update
    void deleteTasks(Long taskID); //delete

    List<Tasks> getAllTasks();  //retrieve all tasks

    //User info that worked in the project
    /*Tasks getTaskByUserId(Long userID);  //retrieve task by user id*/

}
