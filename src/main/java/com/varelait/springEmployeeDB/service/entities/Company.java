package com.varelait.springEmployeeDB.service.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Column(unique = true)
    private String company;
    private String description;

    public Company(){}
    public Company(String company, String description){
        this.company = company;
        this.description = description;
    }

    public Company(String company, String description, int id){
        this.id = id;
        new Company(company, description);
    }
}
