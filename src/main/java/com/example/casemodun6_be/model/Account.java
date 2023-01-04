package com.example.casemodun6_be.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    private String fullName;
    private LocalDate birthday;
    private String gender;
    private String img;
    private long money;

    private LocalDate joinDate;

    @OneToOne
    private DetailAccount detailAccount;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Roles> roles;

    private boolean status;
}
