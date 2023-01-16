package com.example.casemodun6_be.controller;


import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DTO.NotificationDTO;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.model.Roles;
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
        long x90 = user.getMoney() * 90 / 100;
        long x10 = user.getMoney() * 10 / 100;
        long money = detailAccount.getMoney() + x90;
        detailAccount.setMoney(money);
        detailAccountRepo.save(detailAccount);

        DetailAccount detailAccount1 = detailAccountRepo.findById(Long.valueOf(1)).get();
        long money1 = detailAccount1.getMoney() + x10;
        detailAccount1.setMoney(money1);
        detailAccountRepo.save(detailAccount1);
        simpMessagingTemplate.convertAndSend(url, notification);
    }

    @GetMapping("/setSatus2/{id}")
    public ResponseEntity<NotificationDTO> setSatus2(@PathVariable long id) {
        NotificationDTO notificationDTOS = notificationService.setStatus2(id);
        return new ResponseEntity<>(notificationDTOS, HttpStatus.OK);
    }

    @GetMapping("/setSatus5/{id}")
    public ResponseEntity<NotificationDTO> setSatus5(@PathVariable long id) {
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

    @GetMapping("/setSatus8/{id}")
    public ResponseEntity<NotificationDTO> setSatus9(@PathVariable long id) {
        NotificationDTO notificationDTOS = notificationService.setStatus8(id);
        return new ResponseEntity<>(notificationDTOS, HttpStatus.OK);
    }

    @MessageMapping("/newSatus7")
    public void newSatus7(User user) throws Exception {
        NotificationDTO notification = notificationService.newStatus7(user.getId_NDDV(), user.getId_CCDV(), user.getId_Notification(), user.getMoney());
        Account account1 = accountService.finbyid(user.getId_CCDV());
        String url = "/topic/" + account1.getUsername();
        simpMessagingTemplate.convertAndSend(url, notification);
    }

    @MessageMapping("/setSatus7")
    public void setSatus7(User user) throws Exception {
        NotificationDTO notification = notificationService.setStatus7(user.getId_Notification());
        Account account1 = accountService.finbyid(user.getId_CCDV());
        String url = "/topic/" + account1.getUsername();
        simpMessagingTemplate.convertAndSend(url, notification);
    }

    @MessageMapping("/sendAdmin")
    public void sendAdmin(User user) throws Exception {
        NotificationDTO notification = notificationService.newStatus10(user.getId_NDDV(), user.getId_CCDV());
        String url = "/topic/an";
        simpMessagingTemplate.convertAndSend(url, notification);
    }

    @GetMapping("/setSatus13/{id}")
    public ResponseEntity<NotificationDTO> setSatus13(@PathVariable long id) {
        Roles roles = new Roles(3, "ROLE_SERVICE");
        NotificationDTO notificationDTOS = notificationService.setStatus13(id);
        Account account = accountService.finbyid(notificationDTOS.getId_account());
        account.getDetailAccount().getRoles().add(roles);
        iAccountRepo.save(account);
        return new ResponseEntity<>(notificationDTOS, HttpStatus.OK);
    }

    @GetMapping("/setSatus14/{id}")
    public ResponseEntity<NotificationDTO> setSatus14(@PathVariable long id) {
        NotificationDTO notificationDTOS = notificationService.setStatus14(id);
        Account account = accountService.finbyid(notificationDTOS.getId_account());
        account.getDetailAccount().setStatus(0);
        iAccountRepo.save(account);
        return new ResponseEntity<>(notificationDTOS, HttpStatus.OK);
    }

    @MessageMapping("/answerUser")
    public void answerUser(User user) throws Exception {
        NotificationDTO notification = notificationService.newStatus11(user.getId_NDDV(), user.getId_CCDV());
        Account account1 = accountService.finbyid(user.getId_CCDV());
        String url = "/topic/" + account1.getUsername();
        simpMessagingTemplate.convertAndSend(url, notification);
    }

    @MessageMapping("/answerUser1")
    public void answerUser1(User user) throws Exception {
        NotificationDTO notification = notificationService.newStatus12(user.getId_NDDV(), user.getId_CCDV());
        Account account1 = accountService.finbyid(user.getId_CCDV());
        String url = "/topic/" + account1.getUsername();
        simpMessagingTemplate.convertAndSend(url, notification);
    }
}
