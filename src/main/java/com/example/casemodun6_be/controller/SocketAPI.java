package com.example.casemodun6_be.controller;


import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DTO.NotificationDTO;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.model.User;
import com.example.casemodun6_be.repository.DetailAccountRepo;
import com.example.casemodun6_be.repository.IAccountRepo;
import com.example.casemodun6_be.service.AccountService;
import com.example.casemodun6_be.service.EmployService;
import com.example.casemodun6_be.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@CrossOrigin("*")
public class SocketAPI {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    AccountService accountService;

    @Autowired
    IAccountRepo iAccountRepo;

    @Autowired
    NotificationService notificationService;

    @Autowired
    EmployService employService;

    @Autowired
    DetailAccountRepo detailAccountRepo;

//    @MessageMapping("/hello")
//    public void greeting(User user) throws Exception {
//        String url = "/topic/" + user.getName();
//        simpMessagingTemplate.convertAndSend(url, new Hello(user.getMessage()));
//    }

    @GetMapping("/notificationDTO")
    public ResponseEntity<List<NotificationDTO>> showNotification() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        List<NotificationDTO> notificationDTOS = notificationService.showNotification(account.getId());
        return new ResponseEntity<>(notificationDTOS, HttpStatus.OK);
    }

    @MessageMapping("/newNotification")
    public void newNotification(User user) throws Exception {
        NotificationDTO notification = notificationService.newStatus1(user.getId_NDDV(), user.getId_CCDV(), user.getMoney());
        Account account1 = accountService.finbyid(user.getId_CCDV());
        String url = "/topic/" + account1.getUsername();
        simpMessagingTemplate.convertAndSend(url, notification);
    }

    @MessageMapping("/newNotificationAnswer")
    public void newNotificationAnswer(User user) throws Exception {
        NotificationDTO notification = notificationService.newStatus3(user.getId_NDDV(), user.getId_CCDV(), user.getId_Notification(), user.getMoney());
        Account account1 = accountService.finbyid(user.getId_CCDV());
        String url = "/topic/" + account1.getUsername();
        simpMessagingTemplate.convertAndSend(url, notification);
    }

    @MessageMapping("/setSatus4")
    public void setSatus4(User user) throws Exception {
        NotificationDTO notification = notificationService.setStatus4(user.getId_Notification());
        Account account1 = accountService.finbyid(user.getId_CCDV());
        String url = "/topic/" + account1.getUsername();
        simpMessagingTemplate.convertAndSend(url, notification);
    }

    @MessageMapping("/setSatus6")
    public void setSatus6(User user) throws Exception {
        NotificationDTO notification = notificationService.setStatus6(user.getId_Notification());
        Account account1 = accountService.finbyid(user.getId_CCDV());
        String url = "/topic/" + account1.getUsername();
        employService.saveEmploy(user.getId_NDDV(), user.getId_CCDV(), user.getMoney());

        DetailAccount detailAccount = detailAccountRepo.findById(user.getId_CCDV()).get();
        detailAccount.setMoney(user.getMoney());
        detailAccountRepo.save(detailAccount);


        simpMessagingTemplate.convertAndSend(url, notification);
    }

    @GetMapping("/setSatus2/{id}")
    public ResponseEntity<NotificationDTO> setSatus2(@PathVariable long id) {
        NotificationDTO notificationDTOS = notificationService.setStatus2(id);
        return new ResponseEntity<>(notificationDTOS, HttpStatus.OK);
    }

    @GetMapping("/setSatus5/{id}")
    public ResponseEntity<NotificationDTO> setSatus4(@PathVariable long id) {
        NotificationDTO notificationDTOS = notificationService.setStatus5(id);

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        long money = account.getDetailAccount().getMoney() - notificationDTOS.getMoney();

        account.getDetailAccount().setMoney(money);
        iAccountRepo.save(account);

        return new ResponseEntity<>(notificationDTOS, HttpStatus.OK);
    }

    @GetMapping("/setSatus6/{id}")
    public ResponseEntity<NotificationDTO> setSatus6(@PathVariable long id) {
        NotificationDTO notificationDTOS = notificationService.setStatus6(id);
        return new ResponseEntity<>(notificationDTOS, HttpStatus.OK);
    }
}
