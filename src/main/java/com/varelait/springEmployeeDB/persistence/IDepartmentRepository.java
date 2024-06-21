package com.varelait.springEmployeeDB.persistence;

import com.varelait.springEmployeeDB.service.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
}
