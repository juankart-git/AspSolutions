package com.asp.solutions.api.repository;

import com.asp.solutions.api.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
