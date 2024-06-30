package com.varelait.springEmployeeDB.service.company;

import com.varelait.springEmployeeDB.persistence.ICompanyRepository;
import com.varelait.springEmployeeDB.persistence.IRepository;
import com.varelait.springEmployeeDB.service.Service;
import com.varelait.springEmployeeDB.service.entities.Company;
import com.varelait.springEmployeeDB.service.entities.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class CompanyService extends Service<Company, CompanyDTO, Integer> implements ICompanyService{
    ICompanyRepository companyRepository;

    @Autowired
    public CompanyService(ICompanyRepository companyRepository, IRepository<Company, Integer> repository){
        this.companyRepository = companyRepository;
        this.repository = repository;
    }

    @Override
    public Company create(CompanyDTO element){
        Company company = new Company(element.company, element.description);
        return (Company) companyRepository.save(company);
    }

    @Override
    public Page<Company> getByCompany(String pattern, Pageable pageable) {
        return companyRepository.findByCompanyContaining(pattern, pageable);
    }
}
