package com.varelait.springEmployeeDB.service.entities;

import jakarta.annotation.Generated;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Setter
    @Column(unique = true)
    private String department;
    @Setter
    private String description;

    public Department(){}

    public Department(String department, String description){
        this.department = department;
        this.description = description;
    };
    public Department(String department, String description, int id){
        this.department = department;
        this.description = description;
        this.id = id;
    };

}
