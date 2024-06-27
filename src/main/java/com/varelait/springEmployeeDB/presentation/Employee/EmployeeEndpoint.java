package com.varelait.springEmployeeDB.presentation.Employee;

import com.varelait.springEmployeeDB.presentation.StatusEval;
import com.varelait.springEmployeeDB.service.employee.EmployeeService;
import com.varelait.springEmployeeDB.service.employee.IEmployeeService;
import com.varelait.springEmployeeDB.service.entities.Employee;
import com.varelait.springEmployeeDB.service.entities.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeEndpoint {

    IEmployeeService employeeService;
    @Autowired
    public EmployeeEndpoint(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable int id){
        Employee employee = employeeService.delete(id);
        HttpStatus status = StatusEval.object(employee);
        return new ResponseEntity<>(employee, status);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO){
        Employee employee = employeeService.update(id, employeeDTO);
        HttpStatus status = StatusEval.object(employee);
        return new ResponseEntity<>(employee, status);
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = employeeService.create(employeeDTO);
        HttpStatus status = StatusEval.object(employee);
        return new ResponseEntity<>(employee, status);
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> getEmployees(Pageable pageRequest){
        Page<Employee> page = employeeService.get(pageRequest);
        HttpStatus status = StatusEval.object(page);
        return new ResponseEntity<>(page, status);
    }

}
