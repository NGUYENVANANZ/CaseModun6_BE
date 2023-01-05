package com.example.casemodun6_be.model.DTO;

import com.example.casemodun6_be.model.Provided;

import java.util.List;

public class Sart {
    private DetailAccountSart detailAccountSart;
    private double star;

    public DetailAccountSart getDetailAccountSart() {
        return detailAccountSart;
    }

    public void setDetailAccountSart(DetailAccountSart detailAccountSart) {
        this.detailAccountSart = detailAccountSart;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public Sart() {
    }

    public Sart(DetailAccountSart detailAccountSart, double star) {
        this.detailAccountSart = detailAccountSart;
        this.star = star;
    }
}
