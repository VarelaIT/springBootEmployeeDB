package com.varelait.springEmployeeDB.service.department.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity
@Table
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String department;
    private String description;

    public Department(){};
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
