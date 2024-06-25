package com.varelait.springEmployeeDB.service.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class EmployeeDTO {
    @NotNull
    public final String identification;
    @NotNull
    public final String fullname;
    @NotNull
    public final Date birth;
    @ManyToOne
    @JoinColumn(name = "department_id")
    public final Department department;

    public EmployeeDTO(String identification, String fullname, Date birth, Department department){
        this.identification = identification;
        this.fullname = fullname;
        this.birth = birth;
        this.department = department;
    }

}
