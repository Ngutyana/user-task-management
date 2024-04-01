package com.restapi.usertaskssystem.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskID;

    private String name;
    private String description;
    private LocalDate dateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private Users users;

    public Tasks(){
    }

    public Tasks(Long taskID, String name, String description, LocalDate dateTime, Users users) {
        this.taskID = taskID;
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
        this.users = users;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public Long getTaskID() {
        if (users != null){
            return  users.getUserID();
        }
        else {
            return null;
        }
    }

    public void setUserID(Long userID) {
        if (users == null){
           users = new Users();
        }
        users.setUserID(userID);
    }

   /* public void setStatus(String done) {

    }*/
}


