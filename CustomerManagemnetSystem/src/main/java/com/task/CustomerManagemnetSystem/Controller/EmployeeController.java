package com.task.CustomerManagemnetSystem.Controller;


import com.task.CustomerManagemnetSystem.Entity.Employee;
import com.task.CustomerManagemnetSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestParam String adminEmail, @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(adminEmail, employee), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam String adminEmail) {
        return new ResponseEntity<>(employeeService.getEmployeesByAdmin(adminEmail), HttpStatus.OK);
    }
}
