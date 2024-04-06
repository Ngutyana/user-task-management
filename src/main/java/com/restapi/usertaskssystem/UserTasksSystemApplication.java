package com.restapi.usertaskssystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UserTasksSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserTasksSystemApplication.class, args);
	}

}
