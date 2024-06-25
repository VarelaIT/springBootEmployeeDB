package com.varelait.springEmployeeDB.persistence;

import com.varelait.springEmployeeDB.service.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
