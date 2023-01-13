package com.example.casemodun6_be.controller;

import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DTO.EmployDTO;
import com.example.casemodun6_be.model.DTO.ShowProfileDTO;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.repository.DetailAccountRepo;
import com.example.casemodun6_be.repository.IProfileRepo;
import com.example.casemodun6_be.service.AccountService;
import com.example.casemodun6_be.service.EmployService;
import com.example.casemodun6_be.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProfileAPI {

    @Autowired
    AccountService accountService;

    @Autowired
    EmployService employService;

    @Autowired
    DetailAccountRepo detailAccountRepo;

    @Autowired
    ProfileService profileService;

    @Autowired
    IProfileRepo iProfileRepo;


    @GetMapping("/showEmploys")
    public ResponseEntity<List<EmployDTO>> showEmploy() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        List<EmployDTO> employDTOS = employService.showEmloy(account.getId());
        return new ResponseEntity<>(employDTOS, HttpStatus.OK);
    }

    @GetMapping("/showEdit")
    public ResponseEntity<ShowProfileDTO> showEdit() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        ShowProfileDTO showProfileDTOS = profileService.showProfile(account.getId());
        return new ResponseEntity<>(showProfileDTOS,HttpStatus.OK);
    }

    @PostMapping("/editProfile")
    public ResponseEntity<ShowProfileDTO> editProfile(@RequestBody ShowProfileDTO showProfileDTO){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());

        DetailAccount detailAccount1 = profileService.detailAccount(account.getId());

        detailAccount1.setFullName(showProfileDTO.getFullName());
        detailAccount1.setImg(showProfileDTO.getImg());
        detailAccount1.setBirthday(showProfileDTO.getBirthday());
        detailAccount1.setCity(showProfileDTO.getCity());
        detailAccount1.setNation(showProfileDTO.getNation());
        detailAccount1.setGender(showProfileDTO.getGender());
        detailAccount1.setHeight(showProfileDTO.getHeight());
        detailAccount1.setWeight(showProfileDTO.getWeight());
        detailAccount1.setSoThich(showProfileDTO.getSoThich());
        detailAccount1.setMoTa(showProfileDTO.getMoTa());
        detailAccount1.setYeuCau(showProfileDTO.getYeuCau());
        detailAccount1.setMoney(showProfileDTO.getMoney());
        detailAccount1.setFaceLink(showProfileDTO.getFaceLink());
        detailAccount1.setStatus(showProfileDTO.getStatus());
        detailAccount1.setImgs(showProfileDTO.getImgs());
        detailAccount1.setProvideds(showProfileDTO.getProvideds());
        detailAccount1.setComments(showProfileDTO.getComments());
        detailAccount1.setPricePerDay(showProfileDTO.getPricePerDay());
        iProfileRepo.save(detailAccount1);

        ShowProfileDTO showProfileDTO1 = profileService.showProfile(account.getId());
        return new ResponseEntity<>(showProfileDTO1,HttpStatus.OK);
    }


    @GetMapping("/editStatus1")
    public ResponseEntity<DetailAccount> editStatus1() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        DetailAccount detailAccount = account.getDetailAccount();
        detailAccount.setStatus(1);
        detailAccountRepo.save(detailAccount);
        return new ResponseEntity<>(detailAccount, HttpStatus.OK);
    }

    @GetMapping("/editStatus2")
    public ResponseEntity<DetailAccount> editStatus2() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        DetailAccount detailAccount = account.getDetailAccount();
        detailAccount.setStatus(0);
        detailAccountRepo.save(detailAccount);
        return new ResponseEntity<>(detailAccount, HttpStatus.OK);
    }

    @GetMapping("/requsetAdmin1")
    public ResponseEntity<DetailAccount> requsetAdmin1() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        DetailAccount detailAccount = account.getDetailAccount();
        detailAccount.setStatus(1);
        detailAccountRepo.save(detailAccount);
        return new ResponseEntity<>(detailAccount, HttpStatus.OK);
    }

    @GetMapping("/requsetAdmin2")
    public ResponseEntity<DetailAccount> requsetAdmin2() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        DetailAccount detailAccount = account.getDetailAccount();
        detailAccount.setStatus(0);
        detailAccountRepo.save(detailAccount);
        return new ResponseEntity<>(detailAccount, HttpStatus.OK);
    }

    @PostMapping("/saveDetailAccount")
    public ResponseEntity<DetailAccount> save(@RequestBody String img) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        DetailAccount detailAccount = account.getDetailAccount();
        detailAccount.setImg(img);
        detailAccountRepo.save(detailAccount);
        return new ResponseEntity<>(detailAccount, HttpStatus.OK);
    }

}
