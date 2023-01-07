package com.example.casemodun6_be.controller;


import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DTO.DetailAccountSart;
import com.example.casemodun6_be.model.DTO.Hires;
import com.example.casemodun6_be.model.DTO.Sart;
import com.example.casemodun6_be.model.DTO.UserToken;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.repository.DetailAccountRepo;
import com.example.casemodun6_be.service.AccountService;
import com.example.casemodun6_be.service.DeatailAccountService;
import com.example.casemodun6_be.service.JwtService;
import com.example.casemodun6_be.service.search.IAccountServiceSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
public class AccountAPI {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    DetailAccountRepo detailAccountRepo;
    @Autowired
    DeatailAccountService detailAccount;

    @Autowired
    AccountService accountService;

    @Autowired
    IAccountServiceSearch iAccountServiceSearch;

    @PostMapping("/login")
    public ResponseEntity<UserToken> login(@RequestBody Account account) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtService.createToken(authentication);
            Account account1 = accountService.findByName(account.getUsername());
            UserToken userToken = new UserToken(account1.getUsername(), token, account1.getDetailAccount().getRoles(), account1.getStatus());
            return new ResponseEntity<>(userToken, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/newbie")
    public ResponseEntity<List<DetailAccountSart>> showNewbie() {
        List<DetailAccountSart> detailAccounts = detailAccount.showNewbie();
        return new ResponseEntity<>(detailAccounts, HttpStatus.OK);

    }
    @GetMapping("/vip")
    public ResponseEntity<List<DetailAccountSart>> showVip() {
        List<DetailAccountSart> detailAccounts = detailAccount.showVip();
        return new ResponseEntity<>(detailAccounts, HttpStatus.OK);

    }
    @GetMapping("/gender")
    public ResponseEntity<List<DetailAccountSart>> showGender() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
<<<<<<< HEAD
        List<DetailAccountSart> detailAccountSarts = detailAccount.showGender(account.getGender());
        return new ResponseEntity<>(detailAccountSarts, HttpStatus.OK);
=======
        List<DetailAccountSart> detailAccountSarts = detailAccount.showGender(account.getDetailAccount().getGender());
        return new ResponseEntity<>(detailAccountSarts ,HttpStatus.OK);
>>>>>>> ed34d2cd0238dd79868d512a058a205c6632899f
    }

    @GetMapping("/sart")
    public ResponseEntity<List<Sart>> showSart() {

        List<Sart> sarts = detailAccount.showSart();
        return new ResponseEntity<>(sarts, HttpStatus.OK);
    }

    @GetMapping("/hires")
    public ResponseEntity<List<Hires>> showHies() {
        List<Hires> hires = detailAccount.showHires();
        return new ResponseEntity<>(hires, HttpStatus.OK);
    }

    @PostMapping ("/{id}")
    public ResponseEntity<?> statust(@PathVariable long id) {
        Account account = accountService.finbyid(id);
        account.setStatus(false);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<DetailAccount>> showAll(){
        List<DetailAccount> detailAccountList = iAccountServiceSearch.getAll();
        return new ResponseEntity<>(detailAccountList,HttpStatus.OK);
    }
}
