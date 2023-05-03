package com.springbootrest.controller;

import com.springbootrest.model.Employee;
import com.springbootrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return " Employee(s) with id: " + id + " deleted from the database";
    }

    @PostMapping
    public String save(@RequestBody Employee e) {
        return employeeService.save(e) + " Employee(s) saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Employee e, @PathVariable Long id) {
        return employeeService.update(e, id) + " Employee(s) updated successfully";
    }

}