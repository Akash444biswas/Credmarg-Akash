package com.task.CustomerManagemnetSystem.Controller;


import com.task.CustomerManagemnetSystem.Entity.Admin;
import com.task.CustomerManagemnetSystem.Entity.EmailRequest;
import com.task.CustomerManagemnetSystem.Entity.Vendor;
import com.task.CustomerManagemnetSystem.Service.AdminService;
import com.task.CustomerManagemnetSystem.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping
    public ResponseEntity<Vendor> createVendor(@RequestParam String adminEmail, @RequestBody Vendor vendor) {
        return new ResponseEntity<>(vendorService.createVendor(adminEmail, vendor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors(@RequestParam String adminEmail) {
        return new ResponseEntity<>(vendorService.getVendorsByAdmin(adminEmail), HttpStatus.OK);

}
    @PostMapping("/send-emails")
    public ResponseEntity<Void> sendEmailToVendors(@RequestParam String adminEmail, @RequestBody EmailRequest request) {
        List<String> emails = request.getEmails();
        vendorService.sendEmails(adminEmail, emails);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
