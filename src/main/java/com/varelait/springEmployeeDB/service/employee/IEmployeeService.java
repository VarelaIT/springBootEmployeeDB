package com.varelait.springEmployeeDB.service.employee;

import com.varelait.springEmployeeDB.service.entities.Employee;
import com.varelait.springEmployeeDB.service.entities.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    Employee create(EmployeeDTO employee);
    Employee update(int id, EmployeeDTO employee);
    Employee getOne(int id);
    Employee getOne(String identification);
    List<Employee> get(String name);
    List<Employee> get(int limit, int offset);
    Employee delete(int id);
}
