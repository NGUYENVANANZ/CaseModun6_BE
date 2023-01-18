package com.example.casemodun6_be.model.DTO;

import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.model.Roles;

import java.util.List;

public class AccountDTO {
    private long id;
    private String img;
    private String fullName;
    private String Mota;
    private long status;
    private long vip;
    private long money;
    private DetailAccount detailAccount;

    public DetailAccount getDetailAccount() {
        return detailAccount;
    }

    public void setDetailAccount(DetailAccount detailaccount) {
        this.detailAccount = detailaccount;
    }

    public AccountDTO(long id, String img, String fullName, String mota, long status, long vip, DetailAccount detailAccount,long money ) {
        this.id = id;
        this.img = img;
        this.fullName = fullName;
        Mota = mota;
        this.status = status;
        this.vip = vip;
        this.detailAccount = detailAccount;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getVip() {
        return vip;
    }

    public void setVip(long vip) {
        this.vip = vip;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }
}