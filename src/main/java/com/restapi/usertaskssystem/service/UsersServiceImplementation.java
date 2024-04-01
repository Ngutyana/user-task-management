package com.restapi.usertaskssystem.service;

import com.restapi.usertaskssystem.model.Users;
import com.restapi.usertaskssystem.repository.OpsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImplementation implements UsersService{
    private final OpsRepo opsRepo;

    @Autowired
    public UsersServiceImplementation(OpsRepo opsRepo) {
        this.opsRepo = opsRepo;
    }

    @Override
    public Users getUserById(Long userID) {
        Optional<Users>optionalUsers = opsRepo.findById(userID);
        return optionalUsers.orElse(null);
    }

    @Override
    public void saveUser(Users users) {
        opsRepo.save(users);
    }

    @Override
    public void updateUser(Users users) {
        opsRepo.save(users);
    }

    public List<Users> getAllUsers(){
        return opsRepo.findAll();
    }

}
