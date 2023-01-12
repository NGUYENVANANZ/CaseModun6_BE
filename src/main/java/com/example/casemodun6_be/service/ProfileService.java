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

    public List<ShowProfileDTO> showProfile(long id) {
        List<ShowProfileDTO> showProfileDTOS = new ArrayList<>();
        List<DetailAccount> detailAccounts = iProfileRepo.showProfile(id);

        for (DetailAccount d : detailAccounts) {
            showProfileDTOS.add(new ShowProfileDTO(d.getFullName(),d.getImg(),d.getBirthday(),d.getMoney(),d.getCity(),d.getNation(),d.getGender(),d.getHeight(),d.getWeight(),d.getSoThich(),d.getMoTa(),d.getYeuCau()));
        }

        return showProfileDTOS;
    }
    public DetailAccount detailAccount(String username){
        return iProfileRepo.findByFullName(username);
    }
    public DetailAccount detailAccount(long id){
        return iProfileRepo.findDetailAccountById(id);
    }

    public DetailAccount getaccountdetail(long id){
        return iProfileRepo.getaccountdetail(id);
    }

    public Account findaccountbyussername(String username){
        return iAccountRepo.findByUsername(username);
    }

}
