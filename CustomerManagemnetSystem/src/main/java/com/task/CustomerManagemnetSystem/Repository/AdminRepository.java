package com.task.CustomerManagemnetSystem.Repository;

import com.task.CustomerManagemnetSystem.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin , Long> {

    Optional<Admin>  findByEmail(String  email);

}
