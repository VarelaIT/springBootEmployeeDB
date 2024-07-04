package com.varelait.springEmployeeDB.presentation.company;

import com.varelait.springEmployeeDB.presentation.StatusEval;
import com.varelait.springEmployeeDB.service.company.CompanyService;
import com.varelait.springEmployeeDB.service.company.ICompanyService;
import com.varelait.springEmployeeDB.service.entities.Company;
import com.varelait.springEmployeeDB.service.entities.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class CompanyEndpoint {
    ICompanyService service;

    @Autowired
    public CompanyEndpoint(CompanyService companyService){
        this.service = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody CompanyDTO companyDTO){
        Company company = service.create(companyDTO);
        HttpStatus status = StatusEval.object(company);
        return new ResponseEntity<>(company, status);
    }

    @GetMapping
    public ResponseEntity<Page<Company>> getAll(Pageable pageable){
        Page<Company> companies = service.list(pageable);
        HttpStatus status = StatusEval.object(companies);
        return new ResponseEntity<>(companies, status);
    }
}
