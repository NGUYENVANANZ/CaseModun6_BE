package com.example.casemodun6_be.controller;

import com.example.casemodun6_be.model.DetailAccount;
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

    @GetMapping("/{name}")
    public ResponseEntity<List<DetailAccount>> findByName(@PathVariable String name) {
        return new ResponseEntity<>(iAccountServiceSearch.findByName(name), HttpStatus.OK);
    }
}
