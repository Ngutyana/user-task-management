package com.restapi.usertaskssystem.service;

import com.restapi.usertaskssystem.model.Tasks;
import com.restapi.usertaskssystem.repository.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public Tasks getTasksById(Long taskID, Long id) {
        Optional<Tasks>optionalTasks = tasksRepo.findById(taskID);
        return optionalTasks.orElse(null);
    }

    @Override
    public void saveTasks( Tasks tasks) {
        tasksRepo.save(tasks);
    }

    @Override
    public Tasks addTasks(Long userID, Tasks tasks) {
        return tasksRepo.save(tasks);
    }

    @Override
    public void updateTasks(Tasks tasks) {
        tasksRepo.save(tasks);
    }

    @Override
    public void deleteTasks(Long taskID, Long id) {
        tasksRepo.deleteById(taskID);
    }

    //-----------------------------------------------
    /*@Override
    public void updateTasksStatus() {
        List<Tasks> tasks = tasksRepo.findByStatusAndDateTimeBefore("pending", LocalDateTime.now());
        tasks.forEach(task -> {
            task.setStatus("done");
            tasksRepo.save(task);
        });
    }
*/
    // ---------------------------------------------------

    @Override
    public List<Tasks> getAllTasks(Long userID) {
        return tasksRepo.findAll();
    }



}
