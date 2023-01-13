package com.example.casemodun6_be.model.DTO;

import com.example.casemodun6_be.model.Comment;
import com.example.casemodun6_be.model.Img;
import com.example.casemodun6_be.model.Provided;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

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

    private long money;

    private String faceLink;

    private long status;

    private List<Img> imgs;

    private List<Provided> provideds;

    private List<Comment> comments;

    private long pricePerDay;

    public ShowProfileDTO() {
    }

    public ShowProfileDTO(String fullName, String img, LocalDate birthday, String city, String nation, String gender, double height, double weight, String soThich, String moTa, String yeuCau, long money, String faceLink, long status, List<Img> imgs, List<Provided> provideds, List<Comment> comments, long pricePerDay) {
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
        this.money = money;
        this.faceLink = faceLink;
        this.status = status;
        this.imgs = imgs;
        this.provideds = provideds;
        this.comments = comments;
        this.pricePerDay = pricePerDay;
    }
}
