package com.example.casemodun6_be.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ShowProfileDTO {
    private  String fullName;
    private String img;
    private LocalDate birthday;
    private String city;
    private String nation;

    private String gender;

    private double height;
    private double weight;

    private String soThich;
    private String moTa;
    private String yeuCau;


    public ShowProfileDTO() {
    }

    public ShowProfileDTO(String fullName, String img, LocalDate birthday, String city, String nation, String gender, double height, double weight, String soThich, String moTa, String yeuCau) {
        this.fullName = fullName;
        this.img = img;
        this.birthday = birthday;
        this.city = city;
        this.nation = nation;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.soThich = soThich;
        this.moTa = moTa;
        this.yeuCau = yeuCau;
    }
}
