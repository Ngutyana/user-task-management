package com.restapi.usertaskssystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long userID;

    private String userName;
    private String firstName;
    private String lastName;
    public Users() {
    }

    public Users(Long userID, String userName, String firstName, String lastName) {
        this.userID = userID;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
