package com.varelait.springEmployeeDB.service.department;

import com.varelait.springEmployeeDB.service.entities.Department;

import java.util.List;

public interface IDepartmentService {
    Department create(Department departmentRequest);
    List<Department> get(int limit, int offset);
}
