package com.example.casemodun6_be.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long star;
    private String text;

    @ManyToOne
    private Account accounts;

    @ManyToOne
    private DetailAccount detailAccount;
}
