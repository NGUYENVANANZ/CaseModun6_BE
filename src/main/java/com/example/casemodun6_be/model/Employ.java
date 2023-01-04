package com.example.casemodun6_be.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Account account;

    @ManyToOne
    private DetailAccount detailAccount;
}
