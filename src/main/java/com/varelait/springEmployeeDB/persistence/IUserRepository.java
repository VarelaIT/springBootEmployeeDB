package com.varelait.springEmployeeDB.persistence;

import com.varelait.springEmployeeDB.service.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    //@Query("select u from UserEntity u where u.email = ?1")
    UserEntity findByEmail(String email);
}
