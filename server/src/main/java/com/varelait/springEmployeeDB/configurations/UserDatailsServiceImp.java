package com.varelait.springEmployeeDB.configurations;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.varelait.springEmployeeDB.persistence.IUserRepository;
import com.varelait.springEmployeeDB.service.entities.UserEntity;

@Service
public class UserDatailsServiceImp implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(username);
        if(user == null)
            throw new UsernameNotFoundException("Account '" + username + "' not found.");
        return new User(user.getEmail(), user.getHash(), new ArrayList<>());
    }

}
