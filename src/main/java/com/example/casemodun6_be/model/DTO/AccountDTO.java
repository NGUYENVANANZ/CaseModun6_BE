package com.example.casemodun6_be.model.DTO;

import com.example.casemodun6_be.model.Roles;

import java.util.List;

public class AccountDTO {
    private long id;
    private String img;
    private String fullName;
    private String Mota;
    private long status;

    public AccountDTO(long id,String img, String fullName, String mota, long status) {
        this.id = id;
        this.img = img;
        this.fullName = fullName;
        Mota = mota;
        this.status = status;
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



}