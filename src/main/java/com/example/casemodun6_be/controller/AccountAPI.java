package com.example.casemodun6_be.controller;


import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DTO.DetailAccountSart;
import com.example.casemodun6_be.model.DTO.Hires;
import com.example.casemodun6_be.model.DTO.Sart;
import com.example.casemodun6_be.model.DTO.UserToken;
import com.example.casemodun6_be.model.DTO.signup.GenderDTO;
import com.example.casemodun6_be.model.DTO.signup.SignUpForm;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.model.Roles;
import com.example.casemodun6_be.repository.DetailAccountRepo;
import com.example.casemodun6_be.repository.IAccountRepo;
import com.example.casemodun6_be.repository.RolesRepo;
import com.example.casemodun6_be.service.AccountService;
import com.example.casemodun6_be.service.DeatailAccountService;
import com.example.casemodun6_be.service.JwtService;
//import com.example.casemodun6_be.service.SendMailService;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Autowired
    IAccountRepo iAccountRepo;

    @Autowired
    RolesRepo rolesRepo;
//    @Autowired
//    SendMailService sendMailService;



    @PostMapping("/login")
    public ResponseEntity<UserToken> login(@RequestBody Account account) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtService.createToken(authentication);
            Account account1 = accountService.findByName(account.getUsername());
            UserToken userToken = new UserToken(account1.getId(),account1.getUsername(), token, account1.getDetailAccount().getRoles(), account1.getDetailAccount().getImg(), account1.getStatus());
            if (userToken.getStatus() == 0){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(userToken   , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/roles")
    public ResponseEntity<Boolean> checkRoles() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        for (int i = 0; i < account.getDetailAccount().getRoles().size(); i++) {
            if (account.getDetailAccount().getRoles().get(i).getId() == 1) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/roles1")
    public ResponseEntity<Boolean> checkRoles1() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        boolean check = true;
        for (int i = 0; i < account.getDetailAccount().getRoles().size(); i++) {
            if (account.getDetailAccount().getRoles().get(i).getId() == 1) {
                check = false;
            }
        }
        if (check) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/newbie")
    public ResponseEntity<List<DetailAccountSart>> showNewbie() {
        List<DetailAccountSart> detailAccountSarts = detailAccount.showNewbie();
        return new ResponseEntity<>(detailAccountSarts, HttpStatus.OK);
    }

    @GetMapping("/vip")
    public ResponseEntity<List<DetailAccountSart>> showVip() {
        List<DetailAccountSart> detailAccountSarts = detailAccount.showVip();
        return new ResponseEntity<>(detailAccountSarts, HttpStatus.OK);
    }


    @GetMapping("/gender")
    public ResponseEntity<List<DetailAccountSart>> showGender() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        List<DetailAccountSart> detailAccountSarts = detailAccount.showGender(account.getDetailAccount().getGender());
        return new ResponseEntity<>(detailAccountSarts, HttpStatus.OK);
    }


    @GetMapping("/star")
    public ResponseEntity<List<Sart>> showSart() {
        List<Sart> sarts = detailAccount.showSart();
        return new ResponseEntity<>(sarts, HttpStatus.OK);
    }

    @GetMapping("/hires")
    public ResponseEntity<List<Hires>> showHies() {
        List<Hires> hires = detailAccount.showHires();
        return new ResponseEntity<>(hires, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<List<Boolean>> register(@RequestBody SignUpForm signUpForm) {
        List<Boolean> result = new ArrayList<>();
        Account account = new Account();
        DetailAccount detailAccount1 = new DetailAccount();

        Account appUserByEmail = accountService.findByEmail(signUpForm.getEmail());
        Account appUserByName = accountService.findByName(signUpForm.getUsername());
        boolean checkUserName = appUserByName == null;
        boolean checkMail = appUserByEmail == null;

        if (checkMail && checkUserName) {
            detailAccount1.setGender(signUpForm.getGender());
            detailAccount1.setBirthday(signUpForm.getBirthday());
            detailAccount1.setJoinDate(LocalDateTime.now());
            List<Roles> roles = new ArrayList<>();
            roles.add(rolesRepo.findById(2L).get());
            detailAccount1.setRoles(roles);

            detailAccountRepo.save(detailAccount1);
            account.setUsername(signUpForm.getUsername());
            account.setEmail(signUpForm.getEmail());
            account.setPassword(signUpForm.getPassword());
            account.setPhoneNumber(signUpForm.getPhoneNumber());
            account.setDetailAccount(detailAccount1);
            account.setStatus(1);
            iAccountRepo.save(account);
            SendMailAPI sendMailAPI = new SendMailAPI();
            sendMailAPI.sendMail(account.getEmail(), "Chào mừng bạn đến với web thuê nguời yêu", "Tài khoản của bạn là :" + account.getUsername() + "Mật khẩu của bạn là :" + account.getPassword());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            result.add(checkUserName);
            result.add(checkMail);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<DetailAccountSart>> showAll() {
        List<DetailAccountSart> detailAccountList = detailAccount.getAll();
        return new ResponseEntity<>(detailAccountList, HttpStatus.OK);
    }


    @GetMapping("/detailAccount")
    public ResponseEntity<DetailAccount> detailAccount() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        return new ResponseEntity<>(account.getDetailAccount(), HttpStatus.OK);
    }

    @GetMapping("/showDetailAccountbygender/{gender}")
    public ResponseEntity<?> gender(@PathVariable String gender) {
        return new ResponseEntity<>(detailAccountRepo.findAllDetailGender(gender), HttpStatus.OK);
    }

    @GetMapping("/showallgender")
    public ResponseEntity<?> allgender() {
        List<String> genders = detailAccountRepo.findAllGender();
        List<GenderDTO> genderDTOS = new ArrayList<>();
        for (int i = 0; i < genders.size(); i++) {
            GenderDTO genderDTO = new GenderDTO(i + 1, genders.get(i));
            genderDTOS.add(genderDTO);
        }
        return new ResponseEntity<>(genderDTOS, HttpStatus.OK);
    }


}