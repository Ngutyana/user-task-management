package com.restapi.usertaskssystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private LocalDate dateTime = LocalDate.now();

    public Tasks(){

    }

    public Tasks(Long taskID, String name, String description, LocalDate dateTime) {
        this.taskID = taskID;
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
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

}
