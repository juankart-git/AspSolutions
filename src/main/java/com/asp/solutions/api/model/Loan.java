package com.asp.solutions.api.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table()
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long loanValue;

    @Column(nullable = false)
    private Integer installments;

    @Column(nullable = false)
    private Date loanDate;

    @ManyToOne
    @JoinColumn(name = "idEmployee", nullable = false)
    private Employee employee;

}
