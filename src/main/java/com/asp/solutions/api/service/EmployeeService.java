package com.asp.solutions.api.service;

import com.asp.solutions.api.controller.EmployeeController;
import com.asp.solutions.api.model.Employee;
import com.asp.solutions.api.repository.EmployeeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger LOGS = LogManager.getLogger(EmployeeController.class);

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll () {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void delete(Employee employee) { employeeRepository.delete(employee); }

    public Optional<Employee> findById(Integer id) { return employeeRepository.findById(id); }

}
