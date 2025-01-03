package com.varelait.springEmployeeDB.service.user;

import com.varelait.springEmployeeDB.persistence.IUserRepository;
import com.varelait.springEmployeeDB.service.BaseService;
import com.varelait.springEmployeeDB.service.entities.UserEntity;
import com.varelait.springEmployeeDB.service.entities.UserDTO;
import com.varelait.springEmployeeDB.service.entities.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends BaseService implements IUserService, UserDetailsService {

    @Autowired
    private IUserRepository userRepository;


    private UserEntity findByEmail(String email){
       return userRepository.findByEmail(email);
    }

    @Override
    public UserResponse authenticate(UserDTO userRequest){
        UserEntity user = findByEmail(userRequest.email);
        if (user.comparePasswd(userRequest.password))
            return new UserResponse(user.getId(), user.getEmail());

        return null;
    }

    @Override
    public UserResponse find(String email){
        UserEntity user = findByEmail(email);
        if (user == null)
            return null;

        return new UserResponse(user.getId(), user.getEmail());
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = findByEmail(username);
        return new User(user.getEmail(), user.getHash(), new ArrayList<>());
    }
}
