package com.varelait.springEmployeeDB.service.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private Date date;
    @NotNull
    private float salary;
    @NotNull
    private float amount;
    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @NotNull
    private Date createdAt = new Date(System.currentTimeMillis());

    public Payment () {}
    public Payment (Date date, float salary, float amount, Employee employee) {
        this.date = date;
        this.salary = salary;
        this.amount = amount;
        this.employee = employee;
    }
    public Payment (Date date, float salary, float amount, Employee employee, Long id) {
        this.id = id;
        new Payment (date, salary, amount, employee);
    }

}
