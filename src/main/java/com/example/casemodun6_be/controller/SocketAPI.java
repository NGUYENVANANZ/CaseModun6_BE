package com.example.casemodun6_be.controller;


import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DTO.NotificationDTO;
import com.example.casemodun6_be.model.Hello;
import com.example.casemodun6_be.model.User;
import com.example.casemodun6_be.service.AccountService;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@CrossOrigin("*")
@RestController
public class SocketAPI {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    AccountService accountService;

    @Autowired
    NotificationService notificationService;

    @MessageMapping("/hello")
    public void greeting(User user) throws Exception {
        String url = "/topic/" + user.getName();
        simpMessagingTemplate.convertAndSend(url, new Hello(user.getMessage()));
    }

    @GetMapping("/notificationDTO")
    public ResponseEntity<List<NotificationDTO>> showNotification() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByName(userDetails.getUsername());
        List<NotificationDTO> notificationDTOS = notificationService.showNotification(account.getId());
        return new ResponseEntity<>(notificationDTOS, HttpStatus.OK);
    }
}
