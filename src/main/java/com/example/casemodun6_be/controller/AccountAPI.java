package com.example.casemodun6_be.controller;


import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.service.DeatailAccountService;
import com.example.casemodun6_be.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class AccountAPI {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;
    @Autowired
    DeatailAccountService detailAccount;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Account account) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtService.createToken(authentication);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/newbie")
    public ResponseEntity<List<DetailAccount>> showNewbie() {
        List<DetailAccount> detailAccounts = detailAccount.showNewbie();
        return new ResponseEntity<>( detailAccounts, HttpStatus.OK);
    }
}
