package com.task.CustomerManagemnetSystem.Service;

import com.task.CustomerManagemnetSystem.Entity.Admin;
import com.task.CustomerManagemnetSystem.Entity.Employee;
import com.task.CustomerManagemnetSystem.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AdminService adminService;

    public Employee createEmployee(String adminEmail, Employee employee) {
        Admin admin = adminService.getAdminByEmail(adminEmail).orElseThrow(() -> new RuntimeException("Admin not found"));
        employee.setAdmin(admin);
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeesByAdmin(String adminEmail) {
        Admin admin = adminService.getAdminByEmail(adminEmail).orElseThrow(() -> new RuntimeException("Admin not found"));
        return admin.getEmployees();
    }

}
