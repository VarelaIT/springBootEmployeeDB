package com.varelait.springEmployeeDB.service.department;

import com.varelait.springEmployeeDB.persistence.IDepartmentRepository;
import com.varelait.springEmployeeDB.service.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService{

    private final IDepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(IDepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department create(Department departmentRequest) {
        return departmentRepository.save(departmentRequest);
    }

    @Override
    public List<Department> get(int limit, int offset) {
        return departmentRepository.findAll();
    }
}
