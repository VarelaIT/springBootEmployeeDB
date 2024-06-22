package com.varelait.springEmployeeDB.service.entities;

public class DepartmentDto {
    public final int id;
    public final String department;
    public final String description;

    public DepartmentDto (int id, String department, String description){
        this.id = id;
        this.department = department;
        this.description = description;
    }
}
