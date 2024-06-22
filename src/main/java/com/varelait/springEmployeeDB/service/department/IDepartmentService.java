package com.varelait.springEmployeeDB.service.department;

import com.varelait.springEmployeeDB.service.entities.Department;
import com.varelait.springEmployeeDB.service.entities.DepartmentDto;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {
    Optional<Department> delete(int id);
    Department update(DepartmentDto departmentRequest);
    Department create(Department departmentRequest);
    Optional<Department> get(int id);
    List<Department> get(int limit, int offset);
}
