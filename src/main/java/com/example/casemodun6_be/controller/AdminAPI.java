//package com.example.casemodun6_be.controller;
//
//
//import com.example.casemodun6_be.model.Account;
//import com.example.casemodun6_be.service.AccountService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/api/public")
//public class AdminAPI {
//    @GetMapping("/admin")
//    public ResponseEntity<List<Account>> getAll(@RequestParam int index) {
//        List<Account> accounts = AccountService
//        if (accounts.isEmpty()) {
//            return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
//    }
//}