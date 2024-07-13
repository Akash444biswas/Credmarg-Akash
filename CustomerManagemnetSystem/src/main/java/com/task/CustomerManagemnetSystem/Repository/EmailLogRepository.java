package com.task.CustomerManagemnetSystem.Repository;

import com.task.CustomerManagemnetSystem.Entity.Admin;
import com.task.CustomerManagemnetSystem.Entity.EmailLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailLogRepository extends JpaRepository<EmailLog,  Long> {
    List<EmailLog>  findAllByAdmin(Admin admin);
}
