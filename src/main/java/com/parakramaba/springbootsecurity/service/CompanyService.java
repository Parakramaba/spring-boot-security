package com.parakramaba.springbootsecurity.service;

import com.parakramaba.springbootsecurity.entity.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * This Service class implements the business logic of endpoints which are using to handling companies.
 * */
@Service("CompanyService")
public class CompanyService {


    /**
     *
     * @return
     */
    public ResponseEntity<?> getAllCompanies() {
        List<Company> companies = LongStream.rangeClosed(1, 5)
                .mapToObj(i -> new Company(i, "Company " + i, 10))
                .collect(Collectors.toList());

        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    /**
     *
     * @param companyName
     * @return
     */
    public ResponseEntity<?> getCompanyByName(final String companyName) {
        Company company = Company.builder()
                .id(15L)
                .name(companyName)
                .noOfEmployees(75)
                .build();

        return new ResponseEntity<>(company, HttpStatus.OK);
    }
}
