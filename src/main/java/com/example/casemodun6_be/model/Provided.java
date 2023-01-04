package com.example.casemodun6_be.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Provided {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String provided;

}
