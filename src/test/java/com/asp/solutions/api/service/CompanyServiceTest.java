package com.asp.solutions.api.service;

import com.asp.solutions.api.model.Company;
import com.asp.solutions.api.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CompanyServiceTest {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyService companyService;

    private Company company;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        company = new Company();
        company.setId(1L);
        company.setNit("802018262");
        company.setAddress("Cll 123");
    }

    @Test
    void findAll() {
        when(companyRepository.findAll()).thenReturn(Arrays.asList(company));
        assertNotNull(companyService.findAll());
    }

    @Test
    void save() {
        when(companyRepository.save(any())).thenReturn(company);
        assertNotNull(companyService.save(company));
    }

    @Test
    void findById() {
        when(companyRepository.findById(any())).thenReturn(Optional.ofNullable(company));
        assertNotNull(companyService.findAll());
    }
}