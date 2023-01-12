package com.example.casemodun6_be.controller;

import com.example.casemodun6_be.model.DTO.DetailAccountSart;
import com.example.casemodun6_be.model.DTO.Hires;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.repository.DetailAccountRepo;
import com.example.casemodun6_be.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class DeatailAPI {
    @Autowired
    DetailAccountRepo detailAccountRepo;

    @Autowired
    EmployService employService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<DetailAccount> detailFindByID(@PathVariable long id) {
        DetailAccount detailAccount = detailAccountRepo.findById(id).get();
        return new ResponseEntity<>(detailAccount, HttpStatus.OK);
    }


    @GetMapping("/hires/{id}")
    public ResponseEntity<Hires> detailHires(@PathVariable long id) {
        Hires hires = employService.returnEmploy(id);
        return new ResponseEntity<>(hires, HttpStatus.OK);
    }
}
