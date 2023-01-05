package com.example.casemodun6_be.model.DTO;

public class Hires {
    private DetailAccountSart detailAccountSart;
    private long hires;

    public DetailAccountSart getDetailAccountSart() {
        return detailAccountSart;
    }

    public void setDetailAccountSart(DetailAccountSart detailAccountSart) {
        this.detailAccountSart = detailAccountSart;
    }

    public long getHires() {
        return hires;
    }

    public void setHires(long hires) {
        this.hires = hires;
    }

    public Hires() {
    }

    public Hires(DetailAccountSart detailAccountSart, long hires) {
        this.detailAccountSart = detailAccountSart;
        this.hires = hires;
    }


}
