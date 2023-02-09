package com.asp.solutions.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table()
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, precision = 9)
    private String nit;

    @Column(nullable = false)
    private String name;

    private Integer dvNit;

    private String address;

}
