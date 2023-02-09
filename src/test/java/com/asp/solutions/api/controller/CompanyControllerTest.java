package com.asp.solutions.api.controller;

import com.asp.solutions.api.model.Company;
import com.asp.solutions.api.service.CompanyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class CompanyControllerTest {

    @InjectMocks
    private CompanyService companyService;
    private Company company;

    @Test
    void saveCompany() {
    }

    @Test
    void updateCompany() {
    }

    @Test
    void deleteCompany() {
    }

    @Test
    void allCompanies() {
    }
}