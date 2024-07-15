package com.varelait.springEmployeeDB.presentation.views;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController("/")
public class Home {

    @GetMapping
    public ResponseEntity<String> homeView(){
        return new ResponseEntity<>("<h1>Welcome!</h1>", HttpStatus.OK);
    }

}
