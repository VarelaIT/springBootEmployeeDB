package com.varelait.springEmployeeDB.service.user;

import com.varelait.springEmployeeDB.service.entities.UserEntity;
import com.varelait.springEmployeeDB.service.entities.UserDTO;
import com.varelait.springEmployeeDB.service.entities.UserResponse;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    UserResponse create(UserDTO user);
    UserResponse update(int id, UserDTO user);
    UserResponse get(int id);
    List<UserResponse> get();
    UserResponse delete(int id);
}
