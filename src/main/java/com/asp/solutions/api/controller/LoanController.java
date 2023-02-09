package com.asp.solutions.api.controller;

import com.asp.solutions.api.model.Company;
import com.asp.solutions.api.model.Loan;
import com.asp.solutions.api.service.CompanyService;
import com.asp.solutions.api.service.LoanService;
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
@RequestMapping("/loan")
public class LoanController {
    private static final Logger LOGS = LogManager.getLogger(LoanController.class);
    @Autowired
    private LoanService loanService;

    @Autowired
    private Utils util;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveLoan (@Valid @RequestBody Loan loan){
        LOGS.info("[history] Request Save Loan: {}", loan);
        Loan saved = loanService.save(loan);
        return ResponseEntity.ok("Loan saved");
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateLoan (@Valid @RequestBody Loan loan){
        LOGS.info("[history] Request Update Loan: {}", loan);
        Loan saved = loanService.save(loan);
        return ResponseEntity.ok("Loan updated");
    }

    @DeleteMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteLoan (@PathVariable("id") Integer id){
        LOGS.info("[history] Request Delete Loan: ", id);
        Optional<Loan> loan = loanService.findById(id);
        loanService.delete(loan.get());
        return ResponseEntity.ok("Loan deleted");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Loan>> allLoans() {
        LOGS.info("[history] Request Loan find all");
        List<Loan> list = loanService.findAll();
        return ResponseEntity.ok(list);
    }


}
