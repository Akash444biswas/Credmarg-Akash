package com.task.CustomerManagemnetSystem.Repository;

import com.task.CustomerManagemnetSystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee ,  Long> {


}
