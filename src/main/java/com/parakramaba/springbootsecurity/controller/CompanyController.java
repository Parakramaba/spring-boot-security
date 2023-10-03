package com.parakramaba.springbootsecurity.controller;

import com.parakramaba.springbootsecurity.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This Controller class provide set of API endpoints which are using to handling companies.
 */
@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/all")
    public ResponseEntity<?> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/by-name/{companyName}")
    public ResponseEntity<?> getCompanyByName(final @PathVariable("companyName") String companyName) {
        return companyService.getCompanyByName(companyName);
    }
}
