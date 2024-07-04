package com.varelait.springEmployeeDB.service.department;

import com.varelait.springEmployeeDB.LoggerBase;
import com.varelait.springEmployeeDB.persistence.IDepartmentRepository;
import com.varelait.springEmployeeDB.service.entities.Department;
import com.varelait.springEmployeeDB.service.entities.DepartmentDTO;
import jakarta.validation.Valid;
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
        var department2Delete = departmentRepository.findById(id);
        department2Delete.ifPresent(departmentRepository::delete);
        if (department2Delete.isEmpty())
            logger.warn("Trying to delete non existing element");
        return department2Delete;
    }

    @Override
    public Department update(@Valid DepartmentDTO departmentRequest) {
        Optional<Department> department2Update = departmentRepository.findById(departmentRequest.id);
        if (department2Update.isPresent()){
            department2Update.get().setDepartment(departmentRequest.department);
            department2Update.get().setDescription(departmentRequest.description);
            return departmentRepository.save(department2Update.get());
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
