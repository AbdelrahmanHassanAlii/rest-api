package com.springbootrest.service;

import com.springbootrest.model.Employee;
import com.springbootrest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee save(Employee e) {
        return employeeRepository.save(e);
    }


    public Employee update(Employee updatedEmployee, Long id) {
        Optional<Employee> oldEmployee = employeeRepository.findById(id);
        if (oldEmployee.isPresent()) {
            Employee employee = oldEmployee.get();
            employee.setId(updatedEmployee.getId());
            employee.setName(updatedEmployee.getName());
            employee.setLocation(updatedEmployee.getLocation());
            employee.setDepartment(updatedEmployee.getDepartment());
            return employeeRepository.save(employee);
        } else
            return null;
    }
}
