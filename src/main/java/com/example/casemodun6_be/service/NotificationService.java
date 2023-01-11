package com.example.casemodun6_be.service;

import com.example.casemodun6_be.model.DTO.NotificationDTO;
import com.example.casemodun6_be.model.Notification;
import com.example.casemodun6_be.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationRepo notificationRepo;

    public List<NotificationDTO> showNotification(long id) {
        List<NotificationDTO> notificationDTOS = new ArrayList<>();
        List<Notification> notifications = notificationRepo.showNotification(id);

        for (Notification n : notifications) {
            notificationDTOS.add(new NotificationDTO(n.getId(), n.getAccount1().getDetailAccount().getImg(), n.getDate(), n.getMoney(), n.getStatus()));
        }
        return notificationDTOS;
    }
}
