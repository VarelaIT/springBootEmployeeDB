package com.varelait.springEmployeeDB.presentation.department;

import com.varelait.springEmployeeDB.service.department.DepartmentService;
import com.varelait.springEmployeeDB.service.department.IDepartmentService;
import com.varelait.springEmployeeDB.service.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentEndpoint {

    DepartmentService departmentService;

    @Autowired
    public DepartmentEndpoint (DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department create(@RequestBody Department departmentRequest){
        return departmentService.create(departmentRequest);
    }

    @GetMapping
    public List<Department> get(@RequestParam(value="items", defaultValue="100")int limit,
                                @RequestParam(value="page", defaultValue="1") int offset){
        return departmentService.get(limit, offset);
    }
}
