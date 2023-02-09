package com.asp.solutions.api.controller;

import com.asp.solutions.api.model.Employee;
import com.asp.solutions.api.service.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGS = LogManager.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private Utils util;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveEmployee (@Valid @RequestBody Employee employee){
        LOGS.info("[history] Request Save Employee: {}", employee);
        Employee saved = employeeService.save(employee);
        return ResponseEntity.ok("Employee saved");
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateEmployee (@Valid @RequestBody Employee employee){
        LOGS.info("[history] Request Update Employee: {}", employee);
        Employee saved = employeeService.save(employee);
        return ResponseEntity.ok("Employee updated");
    }

    @DeleteMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteEmployee (@PathVariable("id") Integer id){
        LOGS.info("[history] Request Delete Employee: ", id);
        Optional<Employee> employee = employeeService.findById(id);
        employeeService.delete(employee.get());
        return ResponseEntity.ok("Employee deleted");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Employee>> allEmployees() {
        LOGS.info("[history] Request Employee find all");
        List<Employee> list = employeeService.findAll();
        return ResponseEntity.ok(list);
    }


}
