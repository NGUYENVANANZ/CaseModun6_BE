package com.example.casemodun6_be.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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

    private LocalDate date;

    private long money;

    private long hires;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public DetailAccount getDetailAccount() {
        return detailAccount;
    }

    public void setDetailAccount(DetailAccount detailAccount) {
        this.detailAccount = detailAccount;
    }

    public long getHires() {
        return hires;
    }

    public void setHires(long hires) {
        this.hires = hires;
    }
}
