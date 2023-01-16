package com.example.casemodun6_be.service.search;


import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.repository.AdminRepo;
import com.example.casemodun6_be.repository.IAccountRepo;
import com.example.casemodun6_be.repository.ISearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

@Service
public class AccountServiceSearch implements IAccountServiceSearch {
    @Autowired
    ISearchRepo iSearchRepo;

    @Autowired
    AdminRepo adminRepo;


    @Override
    public List<DetailAccount> findByName(String name) {
        return iSearchRepo.findByName(name);
    }

    @Override
    public List<DetailAccount> searchByAll(
            String gender,
//            LocalDate birthday,
            String city) {
        return iSearchRepo.searchByAll(gender, city);
    }


    @Override
    public List<DetailAccount> getAll() {
        return (List<DetailAccount>) iSearchRepo.findAll();
    }


//    @Override
//    public List<DetailAccount> findByName(String fullName) {
//        return iSearchRepo.findByName(fullName);
//    }
//
//    @Override
//    public List<DetailAccount> getAll() {
//        return (List<DetailAccount>) iSearchRepo.findAll() ;
}

