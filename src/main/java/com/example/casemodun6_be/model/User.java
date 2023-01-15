package com.example.casemodun6_be.model;

public class User {
    private long id_CCDV;
    private long id_NDDV;

    private long id_Notification;

    private long money;
    public long getId_CCDV() {
        return id_CCDV;
    }

    public void setId_CCDV(long id_CCDV) {
        this.id_CCDV = id_CCDV;
    }

    public long getId_NDDV() {
        return id_NDDV;
    }

    public void setId_NDDV(long id_NDDV) {
        this.id_NDDV = id_NDDV;
    }

    public long getId_Notification() {
        return id_Notification;
    }

    public void setId_Notification(long id_Notification) {
        this.id_Notification = id_Notification;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public User(long id_CCDV, long id_NDDV, long id_Notification, long money) {
        this.id_CCDV = id_CCDV;
        this.id_NDDV = id_NDDV;
        this.id_Notification = id_Notification;
        this.money = money;
    }

    public User() {
    }

}
