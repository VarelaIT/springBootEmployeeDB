package com.varelait.springEmployeeDB.service.employee;

import com.varelait.springEmployeeDB.persistence.IEmployeeRepository;
import com.varelait.springEmployeeDB.service.Service;
import com.varelait.springEmployeeDB.service.entities.Employee;
import com.varelait.springEmployeeDB.service.entities.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeService extends Service implements IEmployeeService{

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Employee create(EmployeeDTO employee) {
        return employeeRepository.save(new Employee(employee.identification, employee.fullname, employee.birth, employee.department));
    }

    @Override
    public Employee update(int id, EmployeeDTO employee) {
        Employee employee2Update = getOne(id);
        if (employee2Update != null) {
            employee2Update.setIdentification(employee.identification);
            employee2Update.setFullname(employee.fullname);
            employee2Update.setBirth(employee.birth);
            employee2Update.setDepartment(employee.department);
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
        return null;
    }

    @Override
    public List<Employee> get(String name) {
        return null;
    }

    @Override
    public List<Employee> get(int limit, int offset) {
        return null;
    }

    @Override
    public Employee delete(int id) {
        return null;
    }
}
