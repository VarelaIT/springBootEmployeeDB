package com.varelait.springEmployeeDB.persistence;

import com.varelait.springEmployeeDB.service.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
}
