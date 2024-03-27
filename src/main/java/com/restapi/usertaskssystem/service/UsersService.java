package com.restapi.usertaskssystem.service;

import com.restapi.usertaskssystem.model.Users;

import java.util.List;

public interface UsersService {
    Users getUserById(Long userID);  //retrieve user data by id
    void saveUser(Users users);  //creating new user and save in database
    void updateUser(Users users);  //updating user details

    List<Users> getAllUsers();  //retrieve leave of users

}
