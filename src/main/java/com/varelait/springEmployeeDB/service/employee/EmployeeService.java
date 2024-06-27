package com.varelait.springEmployeeDB.service.employee;

import com.varelait.springEmployeeDB.persistence.IDepartmentRepository;
import com.varelait.springEmployeeDB.persistence.IEmployeeRepository;
import com.varelait.springEmployeeDB.service.Service;
import com.varelait.springEmployeeDB.service.entities.Department;
import com.varelait.springEmployeeDB.service.entities.Employee;
import com.varelait.springEmployeeDB.service.entities.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class EmployeeService extends Service implements IEmployeeService{

    private final IEmployeeRepository employeeRepository;
    private final IDepartmentRepository departmentRepository;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository, IDepartmentRepository departmentRepository){
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Employee create(EmployeeDTO employee) {
        Department department = null;
        if (employee.department != null && employee.department.id> 0) {
            Optional<Department> persistedDepartment = departmentRepository.findById(employee.department.id);
            if (persistedDepartment.isPresent())
                department = persistedDepartment.get();
        }
        return employeeRepository.save(new Employee(employee.identification, employee.fullname, employee.birth, department));
    }

    @Override
    public Employee update(int id, EmployeeDTO employee) {
        Employee employee2Update = getOne(id);
        Department department = null;
        if (employee2Update != null) {
            if (employee.department != null && employee.department.id> 0) {
                Optional<Department> persistedDepartment = departmentRepository.findById(employee.department.id);
                if (persistedDepartment.isPresent())
                    department = persistedDepartment.get();
            }
            employee2Update.setIdentification(employee.identification);
            employee2Update.setFullname(employee.fullname);
            employee2Update.setBirth(employee.birth);
            employee2Update.setDepartment(department);
            return employeeRepository.save(employee2Update);
        }
        return null;
    }

    @Override
    public Employee getOne(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @Override
    public Employee getOne(String identification) {
        Optional<Employee> employee = employeeRepository.findByIdentification(identification);
        return employee.orElse(null);
    }

    @Override
    public List<Employee> get(String name) {
        int limit = 100;
        return employeeRepository.findByFullnameContaining(name);
    }

    @Override
    public Page<Employee> get(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee delete(int id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return employee.get();
        }

        return null;
    }
}
