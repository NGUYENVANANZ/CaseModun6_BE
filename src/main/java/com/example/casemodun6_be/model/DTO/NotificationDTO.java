package com.example.casemodun6_be.model.DTO;

import java.time.LocalDate;

public class NotificationDTO {

    private long id;

    private long id_account;


    private String name;

    private String img;

    private LocalDate date;

    private long money;

    private long status;

    private long id_answer;

    public long getId_answer() {
        return id_answer;
    }

    public void setId_answer(long id_answer) {
        this.id_answer = id_answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

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

    public long getId_account() {
        return id_account;
    }

    public void setId_account(long id_account) {
        this.id_account = id_account;
    }

    public NotificationDTO() {
    }

    public NotificationDTO(long id, long id_account, String name, String img, LocalDate date, long money, long status, long id_answer) {
        this.id = id;
        this.id_account = id_account;
        this.name = name;
        this.img = img;
        this.date = date;
        this.money = money;
        this.status = status;
        this.id_answer = id_answer;
    }
}
