package com.example.casemodun6_be.service;

import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.repository.DetailAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeatailAccountService {

    @Autowired
    DetailAccountRepo detailAccountRepo;

    public List<DetailAccount> showNewbie(){
        return detailAccountRepo.findDetailNewbie();
    }
}
