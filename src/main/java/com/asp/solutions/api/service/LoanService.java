package com.asp.solutions.api.service;

import com.asp.solutions.api.controller.LoanController;
import com.asp.solutions.api.model.Loan;
import com.asp.solutions.api.repository.LoanRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private static final Logger LOGS = LogManager.getLogger(LoanController.class);

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> findAll () {
        return loanRepository.findAll();
    }

    public Loan save(Loan loan){
        return loanRepository.save(loan);
    }

    public void delete(Loan loan) { loanRepository.delete(loan); }

    public Optional<Loan> findById(Integer id) { return loanRepository.findById(id); }

}
