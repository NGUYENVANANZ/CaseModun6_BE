package com.example.casemodun6_be.service;

import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DTO.EmployDTO;
import com.example.casemodun6_be.model.DTO.ShowProfileDTO;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.model.Employ;
import com.example.casemodun6_be.repository.IAccountRepo;
import com.example.casemodun6_be.repository.IProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {
    @Autowired
    IProfileRepo iProfileRepo;

    @Autowired
    IAccountRepo iAccountRepo;

    public ShowProfileDTO showProfile(long id) {
        DetailAccount d = iProfileRepo.showProfile(id);
        ShowProfileDTO showProfileDTOS = new ShowProfileDTO(d.getFullName(),d.getImg(),d.getBirthday(),d.getCity(),d.getNation(),d.getGender(),d.getHeight(),d.getWeight(),d.getSoThich(),d.getMoTa(),d.getYeuCau());



        return showProfileDTOS;
    }
    public DetailAccount detailAccount(String username){
        return iProfileRepo.findByFullName(username);
    }
    public DetailAccount detailAccount(long id){
        return iProfileRepo.findDetailAccountById(id);
    }



}
