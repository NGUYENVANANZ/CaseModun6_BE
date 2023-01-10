package com.example.casemodun6_be.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
public class Roles implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Roles() {

    }

    @Override
    public String getAuthority() {
        return name;
    }

    public Roles(long id, String name) {
        this.id = id;
        this.name = name;
    }
}