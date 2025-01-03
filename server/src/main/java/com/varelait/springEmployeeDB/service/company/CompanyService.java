package com.varelait.springEmployeeDB.service.company;

import com.varelait.springEmployeeDB.persistence.ICompanyRepository;
import com.varelait.springEmployeeDB.service.BaseService;
import com.varelait.springEmployeeDB.service.entities.Company;
import com.varelait.springEmployeeDB.service.entities.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends BaseService implements ICompanyService{
    @Autowired
    private ICompanyRepository companyRepository;

    @Override
    public Company create(CompanyDTO element){
        Company company = new Company(element.company, element.description);
        return companyRepository.save(company);
    }

    @Override
    public Page<Company> list(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }
    @Override
    public Page<Company> getByCompany(String pattern, Pageable pageable) {
        return companyRepository.findByCompanyContaining(pattern, pageable);
    }
}
