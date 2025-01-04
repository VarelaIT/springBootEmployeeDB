package com.varelait.springEmployeeDB.service.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @NotNull
    @Email
    public final String email;
    @NotNull
    public final String password;

    public UserDTO(String email, String password){
        this.email = email;
        this.password = password;
    }

}
