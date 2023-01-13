package com.example.casemodun6_be.service;

import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DTO.NotificationDTO;
import com.example.casemodun6_be.model.Notification;
import com.example.casemodun6_be.repository.EmployRepo;
import com.example.casemodun6_be.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationRepo notificationRepo;

    @Autowired
    AccountService accountService;

    public List<NotificationDTO> showNotification(long id) {
        List<NotificationDTO> notificationDTOS = new ArrayList<>();
        List<Notification> notifications = notificationRepo.showNotification(id);

        for (Notification n : notifications) {
            notificationDTOS.add(new NotificationDTO(n.getId(), n.getAccountSend().getId(), n.getAccountSend().getDetailAccount().getFullName(), n.getAccountSend().getDetailAccount().getImg(), n.getDate(), n.getMoney(), n.getStatus(), n.getId_answer()));
        }
        return notificationDTOS;
    }


    public NotificationDTO newStatus1(long id_NDDV, long id_CCDV, long money) {
        Account account = accountService.finbyid(id_NDDV);
        Account account1 = accountService.finbyid(id_CCDV);
        Notification notification = new Notification();
        notification.setAccount(account1);
        notification.setAccountSend(account);
        notification.setMoney(money);
        notification.setDate(LocalDate.now());
        notification.setStatus(1);
        notificationRepo.save(notification);
        NotificationDTO notificationDTO = new NotificationDTO(notification.getId(), notification.getAccountSend().getId(), notification.getAccount().getDetailAccount().getFullName(), notification.getAccountSend().getDetailAccount().getImg(), notification.getDate(), notification.getMoney(), notification.getStatus(), notification.getId_answer());
        return notificationDTO;
    }

    public NotificationDTO setStatus2(long id) {
        Notification notification = notificationRepo.findById(id).get();
        notification.setStatus(2);
        notificationRepo.save(notification);
        NotificationDTO notificationDTO = new NotificationDTO(notification.getId(), notification.getAccountSend().getId(), notification.getAccount().getDetailAccount().getFullName(), notification.getAccountSend().getDetailAccount().getImg(), notification.getDate(), notification.getMoney(), notification.getStatus(), notification.getId_answer());
        return notificationDTO;
    }

    public NotificationDTO newStatus3(long id_NDDV, long id_CCDV, long id_answer, long money) {
        Account account = accountService.finbyid(id_NDDV);
        Account account1 = accountService.finbyid(id_CCDV);
        Notification notification = new Notification();
        notification.setAccount(account1);
        notification.setAccountSend(account);
        notification.setMoney(money);
        notification.setDate(LocalDate.now());
        notification.setStatus(3);
        notification.setId_answer(id_answer);
        notificationRepo.save(notification);
        NotificationDTO notificationDTO = new NotificationDTO(notification.getId(), notification.getAccountSend().getId(), notification.getAccount().getDetailAccount().getFullName(), notification.getAccountSend().getDetailAccount().getImg(), notification.getDate(), notification.getMoney(), notification.getStatus(), notification.getId_answer());
        return notificationDTO;
    }

    public NotificationDTO setStatus4(long id) {
        Notification notification = notificationRepo.findById(id).get();
        notification.setStatus(4);
        notificationRepo.save(notification);
        NotificationDTO notificationDTO = new NotificationDTO(notification.getId(), notification.getAccountSend().getId(), notification.getAccount().getDetailAccount().getFullName(), notification.getAccountSend().getDetailAccount().getImg(), notification.getDate(), notification.getMoney(), notification.getStatus(), notification.getId_answer());
        return notificationDTO;
    }

    public NotificationDTO setStatus5(long id) {
        Notification notification = notificationRepo.findById(id).get();
        notification.setStatus(5);
        notificationRepo.save(notification);
        NotificationDTO notificationDTO = new NotificationDTO(notification.getId(), notification.getAccountSend().getId(), notification.getAccount().getDetailAccount().getFullName(), notification.getAccountSend().getDetailAccount().getImg(), notification.getDate(), notification.getMoney(), notification.getStatus(), notification.getId_answer());
        return notificationDTO;
    }

    public NotificationDTO setStatus6(long id) {
        Notification notification = notificationRepo.findById(id).get();
        notification.setStatus(6);
        notificationRepo.save(notification);
        NotificationDTO notificationDTO = new NotificationDTO(notification.getId(), notification.getAccountSend().getId(), notification.getAccount().getDetailAccount().getFullName(), notification.getAccountSend().getDetailAccount().getImg(), notification.getDate(), notification.getMoney(), notification.getStatus(), notification.getId_answer());
        return notificationDTO;
    }
}
