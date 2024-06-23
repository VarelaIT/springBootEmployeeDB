package com.varelait.springEmployeeDB.service.user;

import com.varelait.springEmployeeDB.persistence.IUserRepository;
import com.varelait.springEmployeeDB.service.Service;
import com.varelait.springEmployeeDB.service.entities.UserEntity;
import com.varelait.springEmployeeDB.service.entities.UserDTO;
import com.varelait.springEmployeeDB.service.entities.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class UserService extends Service implements IUserService {
    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserResponse create(UserDTO user) {
        UserEntity newUser = new UserEntity(user.email, user.password);
        newUser = userRepository.save(newUser);
        return new UserResponse(newUser.getId(), newUser.getEmail());
    }

    @Override
    public UserResponse update(int id, UserDTO user) {
        Optional<UserEntity> user2Update = userRepository.findById(id);
        UserResponse response = null;

        if (user2Update.isPresent()){
            user2Update.get().setEmail(user.email);
            user2Update.get().setPassword(user.password);
            var updatedUser = userRepository.save(user2Update.get());
            response = new UserResponse(updatedUser.getId(), updatedUser.getEmail());
        }

        if (user2Update.isEmpty())
            logger.warn("Trying to update invalid user.");

        return response;
    }

    @Override
    public UserResponse get(int id) {
        UserResponse response = null;
        var user = userRepository.findById(id);

        if (user.isPresent())
            response = new UserResponse(user.get().getId(), user.get().getEmail());

        return response;
    }

    @Override
    public List<UserResponse> get() {
        List<UserResponse> response = new ArrayList<>();
        for (UserEntity user: userRepository.findAll()){
            response.add(new UserResponse(user.getId(), user.getEmail()));
        }

        if (response.isEmpty())
            return null;

        return response;
    }

    @Override
    public UserResponse delete(int id) {
        Optional<UserEntity> user2Delete = userRepository.findById(id);
        UserResponse response = null;
        if (user2Delete.isPresent()) {
            userRepository.delete(user2Delete.get());
            response = new UserResponse(user2Delete.get().getId(), user2Delete.get().getEmail());
        }else
            logger.warn("Trying to delete invalid user.");

        return response;
    }

}
