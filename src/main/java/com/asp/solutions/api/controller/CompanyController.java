package com.asp.solutions.api.controller;

import com.asp.solutions.api.model.Company;
import com.asp.solutions.api.service.CompanyService;
import com.asp.solutions.api.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private static final Logger LOGS = LogManager.getLogger(CompanyController.class);
    @Autowired
    private CompanyService companyService;

    @Autowired
    private Utils util;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveCompany (@Valid @RequestBody Company company){
        LOGS.info("[history] Request Save Company: {}", company);
        Company saved = companyService.save(company);
        return ResponseEntity.ok("Company saved");
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCompany (@Valid @RequestBody Company company){
        LOGS.info("[history] Request Update Company: {}", company);
        Company saved = companyService.save(company);
        return ResponseEntity.ok("Company updated");
    }

    @DeleteMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteCompany (@PathVariable("id") Integer id){
        LOGS.info("[history] Request Delete Company: ", id);
        Optional<Company> company = companyService.findById(id);
        companyService.delete(company.get());
        return ResponseEntity.ok("Company deleted");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Company>> allCompanies() {
        LOGS.info("[history] Request Company find all");
        List<Company> list = companyService.findAll();
        return ResponseEntity.ok(list);
    }

}
