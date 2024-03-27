package com.restapi.usertaskssystem.controller;

import com.restapi.usertaskssystem.model.Users;
import com.restapi.usertaskssystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Printer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@RestController
@RequestMapping("/api/users")
public class usersController {
    private final UsersService usersService;

    @Autowired
    public usersController(UsersService usersService) {
        this.usersService = usersService;
    }

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
        out.print("User created successfully!!");
    }

    @PutMapping //updating user information
    public  void  updateUserInfo(@PathVariable Long userID, @RequestBody Users user){
        Users existingUser = usersService.getUserById(userID);
        if (existingUser != null){
            user.setUserID(userID);
            usersService.saveUser(user);
            out.print("User info updated successfully");
        }
    }

}















