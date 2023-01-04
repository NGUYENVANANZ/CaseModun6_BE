package com.example.casemodun6_be.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class DetailAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String city;
    private String nation;

    private double height;
    private double weight;

    private String soThich;
    private String moTa;
    private String yeuCau;


    private String fullName;
    private LocalDate birthday;
    private String gender;
    private String img;

    private String pricePerDay;

    private String faceLink;


}
