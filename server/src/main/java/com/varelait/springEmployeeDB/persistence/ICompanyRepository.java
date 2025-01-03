package com.varelait.springEmployeeDB.persistence;

import com.varelait.springEmployeeDB.service.entities.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, Integer> {
    Page<Company> findByCompanyContaining(String company, Pageable pageable);
}
