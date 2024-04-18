package com.restapi.usertaskssystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskID;

    private String name;
    private String description;
    private LocalDateTime dateTime;
    private String status;

}

