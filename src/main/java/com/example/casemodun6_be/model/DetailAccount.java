package com.example.casemodun6_be.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class DetailAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String city;
    private String nation;

    private String gender;

    private double height;
    private double weight;

    private String soThich;
    private String moTa;
    private String yeuCau;

    private String fullName;
    private LocalDate birthday;
    private LocalDate joinDate;
    private long money;

    private String img;

    @OneToMany
    private List<Img> imgs;

    @ManyToMany
    private List<Provided> provideds;

    @OneToMany
    private List<Comment> comments;

    private long pricePerDay;

    private String faceLink;

    private long status;

    private long vip;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> roles;

}
