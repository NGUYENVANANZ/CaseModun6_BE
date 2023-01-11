package com.example.casemodun6_be.controller;

import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DTO.AccountDTO;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.model.Roles;
import com.example.casemodun6_be.repository.IAccountRepo;
import com.example.casemodun6_be.repository.IRoleRepo;
import com.example.casemodun6_be.service.AccountService;
import com.example.casemodun6_be.service.DeatailAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
public class AdminAPI {

    @Autowired
    AccountService accountService;

    @Autowired
    DeatailAccountService detailAccount;

    @Autowired
    IAccountRepo iAccountRepo;

    @Autowired
    IRoleRepo iRoleRepo;

    @GetMapping("/lock/{id}")
    public ResponseEntity<List<AccountDTO>> lockroles2(@PathVariable long id) {
        Account account = accountService.finbyid(id);
        account.setStatus(0);
        iAccountRepo.save(account);
        List<Account> accounts = accountService.getAll();
        List<Account> accounts1 = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<Roles> roles = accounts.get(i).getDetailAccount().getRoles();
            for (int j = 0; j < roles.size(); j++) {
                if(accounts.get(i).getDetailAccount().getRoles().get(j).getId()==2){
                    accounts1.add(accounts.get(i));
                }
            }
        }
        List<AccountDTO> dtos = new ArrayList<>();
        for (int i = 0; i < accounts1.size(); i++) {
            AccountDTO accountDTO = new AccountDTO(accounts1.get(i).getId(),accounts1.get(i).getDetailAccount().getImg(),accounts1.get(i).getDetailAccount().getFullName(),accounts1.get(i).getDetailAccount().getMoTa(),accounts1.get(i).getStatus());
            dtos.add(accountDTO);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


    @GetMapping("/unlock/{id}")
    public ResponseEntity<List<AccountDTO>> unlockroles2(@PathVariable long id) {
        Account account = accountService.finbyid(id);
        account.setStatus(1);
        iAccountRepo.save(account);
        List<Account> accounts = accountService.getAll();
        List<Account> accounts1 = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<Roles> roles = accounts.get(i).getDetailAccount().getRoles();
            for (int j = 0; j < roles.size(); j++) {
                if(accounts.get(i).getDetailAccount().getRoles().get(j).getId()==2){
                    accounts1.add(accounts.get(i));
                }
            }
        }
        List<AccountDTO> dtos = new ArrayList<>();
        for (int i = 0; i < accounts1.size(); i++) {
            AccountDTO accountDTO = new AccountDTO(accounts1.get(i).getId(),accounts1.get(i).getDetailAccount().getImg(),accounts1.get(i).getDetailAccount().getFullName(),accounts1.get(i).getDetailAccount().getMoTa(),accounts1.get(i).getStatus());
            dtos.add(accountDTO);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


    @GetMapping("/lock1/{id}")
    public ResponseEntity<List<AccountDTO>> lockroles3(@PathVariable long id) {
        Account account = accountService.finbyid(id);
        account.setStatus(0);
        iAccountRepo.save(account);
        List<Account> accounts = accountService.getAll();
        List<Account> accounts1 = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<Roles> roles = accounts.get(i).getDetailAccount().getRoles();
            for (int j = 0; j < roles.size(); j++) {
                if(accounts.get(i).getDetailAccount().getRoles().get(j).getId()==3){
                    accounts1.add(accounts.get(i));
                }
            }
        }
        List<AccountDTO> dtos = new ArrayList<>();
        for (int i = 0; i < accounts1.size(); i++) {
            AccountDTO accountDTO = new AccountDTO(accounts1.get(i).getId(),accounts1.get(i).getDetailAccount().getImg(),accounts1.get(i).getDetailAccount().getFullName(),accounts1.get(i).getDetailAccount().getMoTa(),accounts1.get(i).getStatus());
            dtos.add(accountDTO);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


    @GetMapping("/unlock1/{id}")
    public ResponseEntity<List<AccountDTO>> unlockroles3(@PathVariable long id) {
        Account account = accountService.finbyid(id);
        account.setStatus(1);
        iAccountRepo.save(account);
        List<Account> accounts = accountService.getAll();
        List<Account> accounts1 = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<Roles> roles = accounts.get(i).getDetailAccount().getRoles();
            for (int j = 0; j < roles.size(); j++) {
                if(accounts.get(i).getDetailAccount().getRoles().get(j).getId()==3){
                    accounts1.add(accounts.get(i));
                }
            }
        }
        List<AccountDTO> dtos = new ArrayList<>();
        for (int i = 0; i < accounts1.size(); i++) {
            AccountDTO accountDTO = new AccountDTO(accounts1.get(i).getId(),accounts1.get(i).getDetailAccount().getImg(),accounts1.get(i).getDetailAccount().getFullName(),accounts1.get(i).getDetailAccount().getMoTa(),accounts1.get(i).getStatus());
            dtos.add(accountDTO);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping("/vip")
    public ResponseEntity<DetailAccount> vip(@PathVariable long vip){
        DetailAccount detailAccount1 = accountService.finbyid(vip).getDetailAccount();
        detailAccount1.setVip(1);
        return new ResponseEntity<>(detailAccount1, HttpStatus.OK);
    }

    @GetMapping("/GetallAccountByRoles2")
    public ResponseEntity<List<AccountDTO>> Accounts() {
        List<Account> accounts = accountService.getAll();
        List<Account> accounts1 = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<Roles> roles = accounts.get(i).getDetailAccount().getRoles();
            for (int j = 0; j < roles.size(); j++) {
                if(accounts.get(i).getDetailAccount().getRoles().get(j).getId()==2){
                    accounts1.add(accounts.get(i));
                }
            }
        }
        List<AccountDTO> dtos = new ArrayList<>();
        for (int i = 0; i < accounts1.size(); i++) {
            AccountDTO accountDTO = new AccountDTO(accounts1.get(i).getId(),accounts1.get(i).getDetailAccount().getImg(),accounts1.get(i).getDetailAccount().getFullName(),accounts1.get(i).getDetailAccount().getMoTa(),accounts1.get(i).getStatus());
            dtos.add(accountDTO);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/GetallAccountByRoles3")
    public ResponseEntity<List<AccountDTO>> Accountsrole3() {
        List<Account> accounts = accountService.getAll();
        List<Account> accounts1 = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<Roles> roles = accounts.get(i).getDetailAccount().getRoles();
            for (int j = 0; j < roles.size(); j++) {
                if(accounts.get(i).getDetailAccount().getRoles().get(j).getId()==3){
                    accounts1.add(accounts.get(i));
                }
            }
        }
        List<AccountDTO> dtos = new ArrayList<>();
        for (int i = 0; i < accounts1.size(); i++) {
            AccountDTO accountDTO = new AccountDTO(accounts1.get(i).getId(),accounts1.get(i).getDetailAccount().getImg(),accounts1.get(i).getDetailAccount().getFullName(),accounts1.get(i).getDetailAccount().getMoTa(),accounts1.get(i).getStatus());
            dtos.add(accountDTO);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}