package com.example.casemodun6_be.model.DTO;

import com.example.casemodun6_be.model.Provided;

import java.time.LocalDate;
import java.util.List;

public class DetailAccountSart {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String fullName;
    private String img;
    private String Mota;
    private List<Provided> provideds;
    private double price;
    private String gender;
    private LocalDate birthday;
    private String city;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public List<Provided> getProvideds() {
        return provideds;
    }

    public void setProvideds(List<Provided> provideds) {
        this.provideds = provideds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public DetailAccountSart() {
    }

    public DetailAccountSart(long id, String fullName, String img, String mota, List<Provided> provideds, double price,String gender, LocalDate birthday ,String city) {
        this.id = id;
        this.fullName = fullName;
        this.img = img;
        Mota = mota;
        this.provideds = provideds;
        this.price = price;
        this.gender = gender;
        this.birthday = birthday;
        this.city = city;
    }
}
