package com.example.casemodun6_be.controller;

import com.example.casemodun6_be.model.DTO.DetailAccountSart;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.service.DeatailAccountService;
import com.example.casemodun6_be.service.search.IAccountServiceSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin("*")
public class SearchAPI {
    @Autowired
    IAccountServiceSearch iAccountServiceSearch;

    @Autowired
    DeatailAccountService deatailAccountService;

    @GetMapping("/{name}")
    public ResponseEntity<List<DetailAccountSart>> findByName(@PathVariable String name) {
        return new ResponseEntity<>(deatailAccountService.search(name), HttpStatus.OK);
    }
}
