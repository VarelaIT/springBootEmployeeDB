package com.varelait.springEmployeeDB.service.department;

import com.varelait.springEmployeeDB.persistence.IDepartmentRepository;
import com.varelait.springEmployeeDB.service.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService extends com.varelait.springEmployeeDB.service.Service implements IDepartmentService{

    private final IDepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(IDepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Optional<Department> delete(int id) {
        try {
            var department2Delete = departmentRepository.findById(id);
            department2Delete.ifPresent(departmentRepository::delete);
            return department2Delete;
        }catch (Exception e){
            this.logger.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Department edit(Department departmentRequest) {
        Department department2Update= departmentRepository.getReferenceById(departmentRequest.getId());
        if (department2Update != null) {
            department2Update.setDepartment(departmentRequest.getDepartment());
            department2Update.setDescription(departmentRequest.getDescription());
            return departmentRepository.save(department2Update);
        }
        return null;
    }

    @Override
    public Department create(Department departmentRequest) {
        return departmentRepository.save(departmentRequest);
    }

    @Override
    public Optional<Department> get(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<Department> get(int limit, int offset) {
        return departmentRepository.findAll();
    }
}
