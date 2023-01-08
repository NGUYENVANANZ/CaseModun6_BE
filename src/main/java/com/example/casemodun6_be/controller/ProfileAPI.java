package com.example.casemodun6_be.controller;

import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DTO.DetailAccountSart;
import com.example.casemodun6_be.model.DTO.EmployDTO;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.repository.DetailAccountRepo;
import com.example.casemodun6_be.service.AccountService;
import com.example.casemodun6_be.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProfileAPI {

    @Autowired
    AccountService accountService;

    @Autowired
    EmployService employService;

    @Autowired
    DetailAccountRepo detailAccountRepo;

    @GetMapping("/showEmploys")
    public ResponseEntity<List<EmployDTO>> showEmploy() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        List<EmployDTO> employDTOS = employService.showEmloy(account.getId());
        return new ResponseEntity<>(employDTOS, HttpStatus.OK);
    }

    @GetMapping("/editStatus1")
    public ResponseEntity<DetailAccount> editStatus1() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        DetailAccount detailAccount = account.getDetailAccount();
        detailAccount.setStatus(1);
        detailAccountRepo.save(detailAccount);
        return new ResponseEntity<>(detailAccount, HttpStatus.OK);
    }

    @GetMapping("/editStatus2")
    public ResponseEntity<DetailAccount> editStatus2() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        DetailAccount detailAccount = account.getDetailAccount();
        detailAccount.setStatus(0);
        detailAccountRepo.save(detailAccount);
        return new ResponseEntity<>(detailAccount, HttpStatus.OK);
    }

    @GetMapping("/requsetAdmin1")
    public ResponseEntity<DetailAccount> requsetAdmin1() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        DetailAccount detailAccount = account.getDetailAccount();
        detailAccount.setStatus(1);
        detailAccountRepo.save(detailAccount);
        return new ResponseEntity<>(detailAccount, HttpStatus.OK);
    }

    @GetMapping("/requsetAdmin2")
    public ResponseEntity<DetailAccount> requsetAdmin2() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        DetailAccount detailAccount = account.getDetailAccount();
        detailAccount.setStatus(0);
        detailAccountRepo.save(detailAccount);
        return new ResponseEntity<>(detailAccount, HttpStatus.OK);
    }
}
