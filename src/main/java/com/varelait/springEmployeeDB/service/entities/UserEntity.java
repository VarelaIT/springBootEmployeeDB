package com.varelait.springEmployeeDB.service.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Column(unique = true)
    @Email
    private String email;
    @NotNull
    private String hash;

    public UserEntity(){}
    public UserEntity(String email, String password){
        this.email = email;
        this.hash = hashPassword(password);
    }

    public UserEntity(String email, String hash, int id){
        this.email = email;
        this.hash = hash;
        this.id = id;
    }

    private String hashPassword(String password){
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder.encode(password);
    }

    public void setPassword(String password){
        this.hash = hashPassword(password);
    }
    public boolean comparePasswd(String password){
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder.matches(password, this.hash);
    }

}
