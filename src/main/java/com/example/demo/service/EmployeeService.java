package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private long nextId = 1;

    public List<Employee> findAll() {
        return employees;
    }

    public Employee findById(Long id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(nextId++);
            employees.add(employee);
        } else {
            deleteById(employee.getId());
            employees.add(employee);
        }
    }

    public void deleteById(Long id) {
        employees.removeIf(e -> e.getId().equals(id));
    }
}
