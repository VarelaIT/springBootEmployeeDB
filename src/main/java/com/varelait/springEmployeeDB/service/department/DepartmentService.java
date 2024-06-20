package com.varelait.springEmployeeDB.service.department;

import com.varelait.springEmployeeDB.service.department.entities.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService{

    @Override
    public Department create(Department departmentRequest) {
        return null;
    }

    @Override
    public List<Department> get(int limit, int offset) {
        return null;
    }
}
