package com.varelait.springEmployeeDB.service.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeDTO {

    public static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    @NotNull
    public String identification;
    @NotNull
    public String fullname;
    @NotNull
    public Date birth;
    public Department department;

    /*
    public EmployeeDTO(String identification, String fullname, String birth) throws ParseException {
        new EmployeeDTO(identification, fullname, birth, null);
    }
     */

    public EmployeeDTO(String identification, String fullname, String birth, Department department) throws ParseException {
        this.identification = identification;
        this.fullname = fullname;
        this.birth = new java.sql.Date(formatter.parse(birth).getTime());
        this.department = department;
    }

}
