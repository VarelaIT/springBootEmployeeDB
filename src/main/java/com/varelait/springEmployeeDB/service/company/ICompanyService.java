package com.varelait.springEmployeeDB.service.company;

import com.varelait.springEmployeeDB.service.IService;
import com.varelait.springEmployeeDB.service.entities.Company;
import com.varelait.springEmployeeDB.service.entities.CompanyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICompanyService extends IService<Company, CompanyDTO, Integer>{
    Company create(CompanyDTO element);
    Page<Company> getByCompany(String pattern, Pageable pageable);
}
