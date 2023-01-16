package com.example.casemodun6_be.controller;

import com.example.casemodun6_be.model.DTO.DetailAccountSart;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.repository.ISearchRepo;
import com.example.casemodun6_be.service.DeatailAccountService;
import com.example.casemodun6_be.service.search.AccountServiceSearch;
import com.example.casemodun6_be.service.search.IAccountServiceSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin("*")
public class SearchAPI {
    @Autowired
    IAccountServiceSearch iAccountServiceSearch;

    @Autowired
    DeatailAccountService deatailAccountService;

    @Autowired
    AccountServiceSearch accountServiceSearch;

    @Autowired
    ISearchRepo iSearchRepo;

    @GetMapping("/{name}")
    public ResponseEntity<List<DetailAccountSart>> findByName(@PathVariable String name) {
        return new ResponseEntity<>(deatailAccountService.search(name), HttpStatus.OK);
    }

    @GetMapping("/searchFilter")
    public ResponseEntity <List<DetailAccount>> searchByAll(
            @RequestParam(name = "gender") String gender,
            @RequestParam(name = "birthday") Date birthday,
            @RequestParam(name = "city") String city

    ) {
        return new ResponseEntity<>(
                accountServiceSearch.searchByAll(gender,birthday, city), HttpStatus.OK);
    }
}
