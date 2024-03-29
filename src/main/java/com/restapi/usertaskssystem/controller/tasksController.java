package com.restapi.usertaskssystem.controller;

import com.restapi.usertaskssystem.model.Tasks;
import com.restapi.usertaskssystem.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;


@RestController
@RequestMapping("/api/users/tasks")  //("/api/users/{userID}/tasks")
public class tasksController {

    @Autowired
    private final TasksService tasksService;

    public tasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/{tasksID}")
    public Tasks getTasksById(@PathVariable Long tasksID) {
        return tasksService.getTasksById(tasksID);
    }

    @GetMapping
    public List<Tasks> getAlTasks(){
        return tasksService.getAllTasks();
    }

    //Where to add users ID
    @PostMapping
    public void addTasks(@RequestBody Tasks tasks){
        tasksService.saveTasks(tasks);
        out.print("Task created successfully");
    }

    @PutMapping("/{tasksID}")
    public void updateTasks(@PathVariable Long tasksID, @RequestBody Tasks tasks){
        Tasks existingTasks = tasksService.getTasksById(tasksID);
        if (existingTasks != null){
            tasks.setTaskID(tasksID);
            tasksService.saveTasks(tasks);
            out.print("Task info updated successfully");
        }
    }

    @DeleteMapping("/{tasksID}")
    public void deleteTasks(@PathVariable Long tasksID){
        tasksService.deleteTasks(tasksID);
        out.print("Task deleted successfully");
    }


}
