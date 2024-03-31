package com.restapi.usertaskssystem.controller;

import com.restapi.usertaskssystem.model.Tasks;
import com.restapi.usertaskssystem.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/users/{userID}/tasks/")
@Component
public class tasksController {

    private final TasksService tasksService;

    @Autowired
    public tasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    // -----------------------------------------------------------------------------------
    /*public void updateTaskStatus() {
        tasksService.updateTasksStatus();
    }*/
    // ------------------------------------------------------------------------------------

    @GetMapping("/{taskID}")
    public ResponseEntity<Tasks> getTasksById(@PathVariable Long userID,@PathVariable Long taskID){
        Tasks tasks = tasksService.getTasksById(userID,taskID);
        if (tasks == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(tasks);
        }
    }

    @GetMapping
    public ResponseEntity<List<Tasks>> getAllTasks(@PathVariable Long userID){
        List<Tasks> tasks = tasksService.getAllTasks(userID);
        if (tasks ==null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(tasks);
        }
    }

    @PostMapping
    public ResponseEntity<Tasks>addTasks(@PathVariable Long userID, @RequestBody Tasks tasks) {
        Tasks addedTasks = tasksService.addTasks(userID, tasks);
        return ResponseEntity.created(URI.create("/api/users/" + userID + "/tasks/" + addedTasks.getTaskID())).body(addedTasks);
        }


    @PutMapping("/{taskID}")
    public ResponseEntity<Tasks> updateTasks(@PathVariable Long userID, @PathVariable Long taskID, @RequestBody Tasks tasks) {
        Tasks existingTask = tasksService.getTasksById(userID, taskID);
        if (existingTask != null){
            tasks.setTaskID(taskID);
            tasksService.saveTasks(tasks);
        }
        return ResponseEntity.ok(existingTask);
    }

    @DeleteMapping("/{taskID}")
    public ResponseEntity<Void> deleteTasks(@PathVariable Long userID, @PathVariable Long taskID) {
        tasksService.deleteTasks(userID, taskID);
        return ResponseEntity.noContent().build();
    }


}

/*
   @PostMapping
    public ResponseEntity<Tasks>addTasks(@PathVariable Long userID, @RequestBody Tasks tasks){
        Tasks addedTasks = tasksService.addTasks(userID, tasks);
        return ResponseEntity.created(URI.create("/api/users/" + userID + "/tasks" + addedTasks.getTaskID())).body(addedTasks);
    }

    @PostMapping
    public ResponseEntity<Tasks> addTasks(@PathVariable Long userID, @RequestBody Tasks tasks) {
        Tasks addedTasks = tasksService.addTasks(userID, tasks);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{taskID}")
                .buildAndExpand(addedTasks.getTaskID())
                .toUri();
        return ResponseEntity.created(location).body(addedTasks);
    }

*/