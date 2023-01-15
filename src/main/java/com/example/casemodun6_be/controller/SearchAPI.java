package com.example.casemodun6_be.controller;

import com.example.casemodun6_be.model.DTO.DetailAccountSart;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.service.DeatailAccountService;
import com.example.casemodun6_be.service.search.AccountServiceSearch;
import com.example.casemodun6_be.service.search.IAccountServiceSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Year;
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

    @GetMapping("/{name}")
    public ResponseEntity<List<DetailAccountSart>> findByName(@PathVariable String name) {
        return new ResponseEntity<>(deatailAccountService.search(name), HttpStatus.OK);
    }

    @GetMapping("/searchFilter")
    public ResponseEntity<Iterable<DetailAccount>> searchByAll(@RequestParam(name = "status") long status,
                                                               @RequestParam(name = "gender") String gender,
                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Year birthday,
                                                               @RequestParam(name = "city") String city,
                                                               @RequestParam(name = "hires") long hires
    ) {
        return new ResponseEntity<>(
                accountServiceSearch.searchByAll(status,gender, LocalDate.from(birthday), city, hires), HttpStatus.OK);
    }
}
