package com.task.CustomerManagemnetSystem.Repository;

import com.task.CustomerManagemnetSystem.Entity.Admin;
import com.task.CustomerManagemnetSystem.Entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendorRepository  extends JpaRepository<Vendor, Long> {
    List<Vendor> findAllByAdmin(Admin admin);
    Optional<Vendor> findByEmail(String email);
}
