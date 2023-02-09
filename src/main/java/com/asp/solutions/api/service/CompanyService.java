package com.asp.solutions.api.service;

import com.asp.solutions.api.controller.CompanyController;
import com.asp.solutions.api.model.Company;
import com.asp.solutions.api.repository.CompanyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private static final Logger LOGS = LogManager.getLogger(CompanyController.class);

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll () {
        return companyRepository.findAll();
    }

    public Company save(Company company){
        company.setDvNit(calculateVerificationDigit(company.getNit()));
        return companyRepository.save(company);
    }

    public void delete(Company company) { companyRepository.delete(company); }

    public Optional<Company> findById(Integer id) { return companyRepository.findById(id); }

    public int calculateVerificationDigit(String companyNit){
        int VD = 0;
        int even = 0;
        int odd = 0;
        String[] nit = companyNit.split("");
        for (int i = 0; i  <  companyNit.length() ; i++)
        {
            if(i % 2 == 0)
                even += Integer.parseInt(nit[i]);
            else
                odd += Integer.parseInt(nit[i]);
        }
        VD = (even * 3) + odd;
        for (int i = 0; i  < companyNit.length(); i++){
            if((VD + i) % 10 == 0){
                VD = i;
                break;
            }
        }
        return VD;
    }

}
