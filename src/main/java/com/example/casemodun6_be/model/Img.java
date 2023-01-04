package com.example.casemodun6_be.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String img;

    @ManyToOne
    private DetailAccount detailAccount;
}
