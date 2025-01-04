package com.varelait.springEmployeeDB.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varelait.springEmployeeDB.service.entities.UserDTO;
import com.varelait.springEmployeeDB.service.user.UserService;

@RestController
@RequestMapping("/api/login")
public class AuthorizationController {

    @Autowired
    AuthenticationManager authManager;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserDTO user){
        try {
            Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.email, user.password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            if(authentication.isAuthenticated())
                return new ResponseEntity<>(user, HttpStatus.OK);
            else
                throw new AuthenticationCredentialsNotFoundException("Unauthenticated.");
        } catch (Exception e) {
            throw new RuntimeException("Unable to respond due to: " + e.getMessage());
        }
    }


}
