package com.varelait.springEmployeeDB.presentation.department;

import com.varelait.springEmployeeDB.service.department.DepartmentService;
import com.varelait.springEmployeeDB.service.department.IDepartmentService;
import com.varelait.springEmployeeDB.service.entities.Department;
import com.varelait.springEmployeeDB.service.entities.DepartmentDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/department")
public class DepartmentEndpoint {


    IDepartmentService departmentService;

    @Autowired
    public DepartmentEndpoint (DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Department>> delete(@PathVariable int id){
        Optional<Department> department = departmentService.delete(id);
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (department.isPresent())
            status = HttpStatus.OK;

       return new ResponseEntity<>(department, status);
    }

    @PatchMapping
    public ResponseEntity<Department> update(@Valid @RequestBody DepartmentDTO departmentRequest){
        Department department = departmentService.update(departmentRequest);
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (department != null)
            status = HttpStatus.OK;

        return new ResponseEntity<>(department, status);
    }

    @PostMapping
    public ResponseEntity<Department> create(@Valid @RequestBody Department departmentRequest){
        Department department = departmentService.create(departmentRequest);
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (department != null)
            status = HttpStatus.OK;

        return new ResponseEntity<>(department, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Department>> get(@PathVariable int id){
        Optional<Department> department = departmentService.get(id);
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (department.isPresent())
            status = HttpStatus.OK;

        return new ResponseEntity<>(department, status);
    }

    @GetMapping
    public ResponseEntity<List<Department>> get(@RequestParam(value="items", defaultValue="100")int limit,
                                @RequestParam(value="page", defaultValue="1") int offset){
        List<Department> departments = departmentService.get(limit, offset);
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (!departments.isEmpty())
            status = HttpStatus.OK;

        return new ResponseEntity<>(departments, status);
    }
}
