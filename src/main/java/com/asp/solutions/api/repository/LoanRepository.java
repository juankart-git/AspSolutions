package com.asp.solutions.api.repository;

import com.asp.solutions.api.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
