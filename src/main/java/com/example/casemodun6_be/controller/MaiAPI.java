//package com.example.casemodun6_be.controller;
//
//import com.example.casemodun6_be.model.Account;
//import com.example.casemodun6_be.service.SendMailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
//public class MaiAPI {
//    @Autowired
//    SendMailService sendMailService;
//
//    @PostMapping("/send")
//    public boolean send(@RequestBody Account account){
//        return sendMailService.sendMail(account.getEmail(),"Xác nhân !", account.getEmail())+"\nMã xác nhận của bạn là: ");
//    }
//    @GetMapping("/confirm")
//    public String confirm(@RequestParam("code") String code){
//        return sendMailService.confirmCode(code);
//    }
//    @GetMapping("/resetcode")
//    public void resetcode(){
//        sendMailService.rsCode();
//    }
//}
