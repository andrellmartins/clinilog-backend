package com.pucpr.backend.resource.controller;

import com.pucpr.backend.model.tables.Employee;
import com.pucpr.backend.resource.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/{id}")
    public Object getById(@PathVariable long id) {
        return employeeService.findById(id);
    }

    @GetMapping(value = "/")
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Employee> save(
            @RequestBody Employee employee) {
        employeeService.save(employee) ;
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/")
    public ResponseEntity<Employee> update(
            @RequestBody Employee employee) {
        employeeService.save(employee);
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        employeeService.deleteById(id);
        return ResponseEntity.ok().body("Employee " + id + " excluded");
    }
}
