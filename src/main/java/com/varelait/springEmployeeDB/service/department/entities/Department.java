package com.varelait.springEmployeeDB.service.department.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Department {

    @Id

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
