package com.example.casemodun6_be.model.DTO;

import com.example.casemodun6_be.model.Account;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class NotificationDTO {

    private long id;

    private String img;

    private LocalDate date;

    private long money;

    private long status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public NotificationDTO() {
    }

    public NotificationDTO(long id, String img, LocalDate date, long money, long status) {
        this.id = id;
        this.img = img;
        this.date = date;
        this.money = money;
        this.status = status;
    }
}
