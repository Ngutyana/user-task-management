package com.restapi.usertaskssystem.controller;

import com.restapi.usertaskssystem.model.Tasks;
import com.restapi.usertaskssystem.model.UserTasks;
import com.restapi.usertaskssystem.model.Users;
import com.restapi.usertaskssystem.service.TasksService;
import com.restapi.usertaskssystem.service.UserTasksService;
import com.restapi.usertaskssystem.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Printer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class usersController {

    private final UsersService usersService;
    private final TasksService tasksService;
    private  final UserTasksService userTasksService;

    @GetMapping("/{userID}")  //retrieve data by id
    public Users getUserById(@PathVariable Long userID) {
        return usersService.getUserById(userID);
    }

    @GetMapping  //retrieve all users from database
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @PostMapping  //creating new user
    public void createUser(@RequestBody Users users){
        usersService.saveUser(users);
    }

    @PutMapping ("/{userID}")
    //updating user information
    public  void  updateUserInfo(@PathVariable Long userID, @RequestBody Users user){
        Users existingUser = usersService.getUserById(userID);
        if (existingUser != null){
            user.setUserID(userID);
            usersService.saveUser(user);
        }
    }

    @PostMapping("/{userID}/tasks") //create task by user id
    public ResponseEntity<Object> createTasks(@PathVariable Long userID, @RequestBody Tasks tasks) {
        Users existingUser = usersService.getUserById(userID);
        if (existingUser == null){
            return new ResponseEntity<>("user doesn't exist!!", HttpStatus.NOT_FOUND);
        }
        tasks.setDateTime(LocalDateTime.now());
        tasks.setStatus("Pending");
        Tasks addedTasks = tasksService.saveTasks(tasks);
        UserTasks userTasks = new UserTasks();
        userTasks.setUserID(existingUser.userID);
        userTasks.setTaskID( addedTasks.getTaskID());
        userTasksService.saveUserTasks(userTasks);
        return ResponseEntity.created(URI.create("/api/users/" + userID + "/tasks/" + addedTasks.getTaskID())).body(addedTasks);
    }

    @GetMapping("/{userID}/tasks") //get all tasks by user id
    public  ResponseEntity<Object> getAllTasks(@PathVariable Long userID) {
        Users existingUser = usersService.getUserById(userID);
        if (existingUser == null) {
            return new ResponseEntity<>("user doesn't exist!!", HttpStatus.NOT_FOUND);
        }
        List<UserTasks> userTasks = userTasksService.getUserTasks(userID);
        List<Tasks> tasks = new ArrayList<>();
        for (int i=0; i<userTasks.size(); i++){
            Tasks task = tasksService.findById(userTasks.get(i).getTaskID());
            tasks.add(task);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/{userID}/tasks/{taskID}") //update task information
    public ResponseEntity<Object> updateTasks(@PathVariable Long userID, @PathVariable Long taskID, @RequestBody Tasks tasks) {
        Users existingUser = usersService.getUserById(userID);
        if (existingUser == null) {
            return new ResponseEntity<>("user doesn't exist with id: "+ userID, HttpStatus.NOT_FOUND);
        }
        Tasks existingTask = tasksService.getTasksById(taskID);

        if (existingTask == null){
            return new ResponseEntity<>("task doesn't exist with id: " + taskID, HttpStatus.NOT_FOUND);
        }
        if (userTasksService.existsByUserIDEqualsAndTaskIDEquals(userID,taskID)) {
            existingTask.setName(tasks.getName());
            existingTask.setDescription(tasks.getDescription());
            existingTask.setDateTime(LocalDateTime.now());
            existingTask.setStatus("Pending");
            tasksService.saveTasks(existingTask);
            return ResponseEntity.ok(existingTask);
        }
        return new ResponseEntity<>("task id doesnt match user id", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{userID}/tasks/{taskID}") // Get a task by user id and task id
    public ResponseEntity<Object> getTask(@PathVariable Long userID, @PathVariable Long taskID) {
        Users existingUser = usersService.getUserById(userID);
        if (existingUser == null) {
            return new ResponseEntity<>("User doesn't exist!!", HttpStatus.NOT_FOUND);
        }
        if (!userTasksService.existsByUserIDEqualsAndTaskIDEquals(userID, taskID)) {
            return new ResponseEntity<>("Task doesn't exist for the given user!!", HttpStatus.NOT_FOUND);
        }
        Tasks task = tasksService.findById(taskID);
        if (task == null) {
            return new ResponseEntity<>("Task not found!!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/{userID}/tasks/{taskID}") //delete task
    public ResponseEntity<Object> deleteTask(@PathVariable Long userID, @PathVariable Long taskID) {
        Users existingUser = usersService.getUserById(userID);
        if (existingUser == null) {
            return new ResponseEntity<>("User not found!",HttpStatus.NOT_FOUND);
        }
        if (!userTasksService.existsByUserIDEqualsAndTaskIDEquals(userID, taskID)) {
            return new ResponseEntity<>("Task not found",HttpStatus.NOT_FOUND);
        }
        tasksService.deleteTasks(taskID);
        return ResponseEntity.noContent().build();
    }


}















