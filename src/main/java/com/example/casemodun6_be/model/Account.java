package com.example.casemodun6_be.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    private long money;
    private String gender;

    @OneToOne
    private DetailAccount detailAccount;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Roles> roles;

    private boolean status;
}
