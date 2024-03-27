package com.restapi.usertaskssystem.repository;

import com.restapi.usertaskssystem.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpsRepo extends JpaRepository<Users, Long> {
}
