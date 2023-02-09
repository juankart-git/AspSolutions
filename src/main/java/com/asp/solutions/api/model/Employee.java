package com.asp.solutions.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table()
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private Long salary;

    @Column(nullable = false)
    private Date hiringDate;

    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "idCompany", nullable = false)
    private Company company;

}
