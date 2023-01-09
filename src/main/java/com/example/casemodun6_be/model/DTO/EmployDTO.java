package com.example.casemodun6_be.model.DTO;

import java.time.LocalDate;
import java.util.Date;

public class EmployDTO {
    private  String userName;
    private String img;
    private LocalDate date;
    private long price;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public EmployDTO() {
    }

    public EmployDTO(String userName, String img, LocalDate date, long price) {
        this.userName = userName;
        this.img = img;
        this.date = date;
        this.price = price;
    }
}
