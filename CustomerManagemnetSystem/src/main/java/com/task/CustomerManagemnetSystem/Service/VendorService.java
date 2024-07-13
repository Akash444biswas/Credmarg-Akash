package com.task.CustomerManagemnetSystem.Service;

import com.task.CustomerManagemnetSystem.Entity.Admin;
import com.task.CustomerManagemnetSystem.Entity.EmailLog;
import com.task.CustomerManagemnetSystem.Entity.Vendor;
import com.task.CustomerManagemnetSystem.Repository.EmailLogRepository;
import com.task.CustomerManagemnetSystem.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EmailLogRepository emailLogRepository;

    public Vendor createVendor(String adminEmail, Vendor vendor) {
        Admin admin = adminService.getAdminByEmail(adminEmail).orElseThrow(() -> new RuntimeException("Admin not found"));
        vendor.setAdmin(admin);
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getVendorsByAdmin(String adminEmail) {
        Admin admin = adminService.getAdminByEmail(adminEmail).orElseThrow(() -> new RuntimeException("Admin not found"));
        return vendorRepository.findAllByAdmin(admin);
    }

    public void sendEmails(String adminEmail, List<String> emails) {
        Admin admin = adminService.getAdminByEmail(adminEmail).orElseThrow(() -> new RuntimeException("Admin not found"));
        for (String email : emails) {
            Vendor vendor = vendorRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Vendor not found"));
            String emailContent = "Sending payments to vendor " + vendor.getName() + " at upi " + vendor.getUpi();
            EmailLog emailLog = new EmailLog();
            emailLog.setEmailContent(emailContent);
            emailLog.setAdmin(admin);
            emailLog.setVendor(vendor);
            emailLog.setTimestamp(LocalDateTime.now());
            emailLogRepository.save(emailLog);
            System.out.println(emailContent);
        }
    }

    public List<EmailLog> getEmailLogsByAdmin(String adminEmail) {
        Admin admin = adminService.getAdminByEmail(adminEmail).orElseThrow(() -> new RuntimeException("Admin not found"));
        return emailLogRepository.findAllByAdmin(admin);
    }

}
