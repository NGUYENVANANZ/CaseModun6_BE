package com.example.casemodun6_be.service;

import com.example.casemodun6_be.model.*;
import com.example.casemodun6_be.model.DTO.DetailAccountSart;
import com.example.casemodun6_be.model.DTO.EmployDTO;
import com.example.casemodun6_be.repository.AdminRepo;
import com.example.casemodun6_be.repository.DetailAccountRepo;
import com.example.casemodun6_be.repository.EmployRepo;
import com.example.casemodun6_be.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    IAccountRepo iAccountRepo;

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    DetailAccountRepo detailAccountRepo;

    @Autowired
    EmployRepo employRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.findByUsername(username);
        if (account != null) {
            return new User(account.getUsername(), account.getPassword(), account.getDetailAccount().getRoles());
        }
        return null;
    }

    public List<Account> getAll() {
        return (List<Account>) iAccountRepo.findAll();
    }
    public List<Employ> getAlls() {
        return (List<Employ>) employRepo.findAll();
    }
    public DetailAccount save(DetailAccount detailAccount){
        return detailAccountRepo.save(detailAccount);
    }

    public Account findByName(String name) {
        return iAccountRepo.findByUsername(name);
    }

    public Account findbysdt(String phoneNumber) {
        return iAccountRepo.findByPhoneNumber(phoneNumber);
    }

    public Account findByEmail(String email) {
        return iAccountRepo.findByUsername(email);
    }

    public Account finbyid(long id) {
        return iAccountRepo.findById(id);
    }

    public DetailAccount finbyidhihi(long id){
        return detailAccountRepo.findByViphihi(id);
    }

    public DetailAccount finbyVip(long vip,long id){
        return detailAccountRepo.findByVip(vip,id);
    }

    public List<Employ> finallempoy(){
        return employRepo.showEmployall();
    }
}