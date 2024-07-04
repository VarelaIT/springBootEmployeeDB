package com.varelait.springEmployeeDB.service.entities;

import jakarta.validation.constraints.NotNull;

public class CompanyDTO {

    public int id;
    @NotNull
    public String company;
    public String description;

    public CompanyDTO(){
    }

    public CompanyDTO(String company, String description){
        this.company = company;
        this.description = description;
    }

    public CompanyDTO(String company, String description, int id){
        this.id = id;
        new CompanyDTO(company, description);
    }
}
