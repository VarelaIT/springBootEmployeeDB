package com.varelait.springEmployeeDB.service.entities;

import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PaymentDTO {

    public static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public int id = 0;
    public Date date;
    public float salary;
    public float amount;
    public int employeeId;

    public PaymentDTO(){}
    public PaymentDTO (String date, float salary, float amount, int employeeId) throws ParseException {
        this.date = new Date(formatter.parse(date).getTime());
        this.salary = salary;
        this.amount = amount;
        this.employeeId = employeeId;
    }

    public PaymentDTO (String date, float salary, float amount, int employeeId, int id) throws ParseException {
        this.id = id;
        new PaymentDTO(date, salary, amount, employeeId);
    }

}
