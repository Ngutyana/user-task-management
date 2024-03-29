package com.restapi.usertaskssystem.service;

import com.restapi.usertaskssystem.model.Tasks;
import com.restapi.usertaskssystem.model.Users;
import com.restapi.usertaskssystem.repository.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksServiceImplementation implements TasksService  {

    private final TasksRepo tasksRepo;

    @Autowired
    public TasksServiceImplementation(TasksRepo tasksRepo) {
        this.tasksRepo = tasksRepo;
    }

    @Override
    public Tasks getTasksById(Long taskID) {
        Optional<Tasks>optionalTasks = tasksRepo.findById(taskID);
        return optionalTasks.orElse(null);
    }

    @Override
    public void saveTasks(Tasks tasks) {
        tasksRepo.save(tasks);
    }

    @Override
    public void updateTasks(Tasks tasks) {
        tasksRepo.save(tasks);
    }

    @Override
    public void deleteTasks(Long taskID) {
        tasksRepo.deleteById(taskID);
    }

    @Override
    public List<Tasks> getAllTasks() {
        return tasksRepo.findAll();
    }

/*
    @Override
    public Users getUserById(Long userID) {
        return null;
    }

    @Override
    public void saveUser(Users users) {

    }

    @Override
    public void updateUser(Users users) {

    }

    @Override
    public List<Users> getAllUsers() {
        return null;
    }*/
}
