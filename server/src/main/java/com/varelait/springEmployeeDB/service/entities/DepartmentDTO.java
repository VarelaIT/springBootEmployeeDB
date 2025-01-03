package com.varelait.springEmployeeDB.service.entities;

import jakarta.validation.constraints.NotNull;

public class DepartmentDTO {
    public final int id;
    @NotNull(message = "This property can not be null.")
    public final String department;
    @NotNull(message = "This property can not be null.")
    public final String description;

    public DepartmentDTO(int id, String department, String description){
        this.id = id;
        this.department = department;
        this.description = description;
    }
}
