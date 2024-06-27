package com.varelait.springEmployeeDB.service.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Column(unique = true)
    private String identification;
    @NotNull
    private String fullname;
    @NotNull
    private Date birth;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(){}

    public Employee(String identification, String fullname, Date birth, Department department){
        this.identification = identification;
        this.fullname = fullname;
        this.birth = birth;
        this.department = department;
    }

    public Employee(String identification, String fullname, Date birth, Department department, int id){
        this.id = id;
        new Employee(identification, fullname, birth, department);
    }
}
