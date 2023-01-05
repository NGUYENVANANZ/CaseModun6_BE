package com.example.casemodun6_be.model.DTO;

import com.example.casemodun6_be.model.Provided;

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

    public DetailAccountSart() {
    }

    public DetailAccountSart(long id, String fullName, String img, String mota, List<Provided> provideds, double price) {
        this.id = id;
        this.fullName = fullName;
        this.img = img;
        Mota = mota;
        this.provideds = provideds;
        this.price = price;
    }
}
