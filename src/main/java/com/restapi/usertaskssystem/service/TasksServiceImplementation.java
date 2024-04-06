package com.restapi.usertaskssystem.service;

import com.restapi.usertaskssystem.model.Tasks;
import com.restapi.usertaskssystem.repository.TasksRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TasksServiceImplementation implements TasksService  {

    private final TasksRepo tasksRepo;

   /* @Autowired
    public TasksServiceImplementation(TasksRepo tasksRepo) {
        this.tasksRepo = tasksRepo;
    }*/

    @Override
    public Tasks getTasksById(Long taskID) {
        Optional<Tasks>optionalTasks = tasksRepo.findById(taskID);
        return optionalTasks.orElse(null);
    }


    @Override
    public Tasks saveTasks(Tasks tasks) {
        return tasksRepo.save(tasks);
    }

    @Override
    public void updateTasks(Tasks tasks) {
        tasksRepo.save(tasks);
    }


    public void updateTaskStatus() {
        LocalDate localDate = LocalDate.now();
        List<Tasks> tasks = tasksRepo.findByStatusAndDateTimeBefore("Pending", localDate);
        for (Tasks task : tasks) {
            task.setStatus("Done");
            tasksRepo.save(task);
        }
    }

    @Override
    public void deleteTasks(Long taskID, Long id) {
        tasksRepo.deleteById(taskID);
    }

    @Override
    public List<Tasks> getAllTasks(Long userID) {
        return tasksRepo.findAll();
    }

    @Override
    public Tasks findById(Long taskID) {
        return tasksRepo.findById(taskID).orElse(null);
    }
}
