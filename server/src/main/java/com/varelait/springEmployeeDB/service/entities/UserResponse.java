package com.varelait.springEmployeeDB.service.entities;

public class UserResponse {

    public final int id;
    public final String email;

    public UserResponse(int id, String email){
        this.id = id;
        this.email = email;
    }
}
