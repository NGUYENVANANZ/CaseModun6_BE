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
            UserToken userToken = new UserToken(account1.getUsername(), token, account1.getRoles());
            return new ResponseEntity<>(userToken, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/newbie")
    public ResponseEntity<List<DetailAccountSart>> showNewbie() {
<<<<<<< HEAD
        List<DetailAccountSart> detailAccounts = detailAccount.showNewbie();
        return new ResponseEntity<>(detailAccounts, HttpStatus.OK);
=======
        List<DetailAccountSart> detailAccountSarts = detailAccount.showNewbie();
        return new ResponseEntity<>( detailAccountSarts, HttpStatus.OK);
>>>>>>> 1a283fb7492c1cd28560bb4b3d0700dbfe60fa4f
    }
    @GetMapping("/vip")
    public ResponseEntity<List<DetailAccountSart>> showVip() {
<<<<<<< HEAD
        List<DetailAccountSart> detailAccounts = detailAccount.showVip();
        return new ResponseEntity<>(detailAccounts, HttpStatus.OK);
=======
        List<DetailAccountSart> detailAccountSarts = detailAccount.showVip();
        return new ResponseEntity<>( detailAccountSarts, HttpStatus.OK);
>>>>>>> 1a283fb7492c1cd28560bb4b3d0700dbfe60fa4f
    }
    @GetMapping("/gender")
    public ResponseEntity<List<DetailAccountSart>> showGender() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        List<DetailAccountSart> detailAccountSarts = detailAccount.showGender(account.getGender());
        return new ResponseEntity<>(detailAccountSarts, HttpStatus.OK);
    }

<<<<<<< HEAD
    @GetMapping("/sart")
    public ResponseEntity<List<Sart>> showSart() {
=======
    @GetMapping("/star")
    public ResponseEntity<List<Sart>> showSart(){
>>>>>>> 1a283fb7492c1cd28560bb4b3d0700dbfe60fa4f
        List<Sart> sarts = detailAccount.showSart();
        return new ResponseEntity<>(sarts, HttpStatus.OK);
    }

    @GetMapping("/hires")
    public ResponseEntity<List<Hires>> showHies() {
        List<Hires> hires = detailAccount.showHires();
        return new ResponseEntity<>(hires, HttpStatus.OK);
    }

<<<<<<< HEAD
    @PostMapping ("/{id}")
    public ResponseEntity<?> statust(@PathVariable long id) {
        Account account = accountService.finbyid(id);
        account.setStatus(false);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
=======
    @GetMapping("/showAll")
    public ResponseEntity<List<DetailAccount>> showAll(){
        List<DetailAccount> detailAccountList = iAccountServiceSearch.getAll();
        return new ResponseEntity<>(detailAccountList,HttpStatus.OK);
    }
}
>>>>>>> 1a283fb7492c1cd28560bb4b3d0700dbfe60fa4f
