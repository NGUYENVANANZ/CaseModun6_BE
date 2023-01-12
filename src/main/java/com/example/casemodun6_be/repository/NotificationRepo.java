package com.example.casemodun6_be.repository;

import com.example.casemodun6_be.model.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends PagingAndSortingRepository<Notification,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM notification WHERE account_id =:account_id ORDER BY date DESC")
    List<Notification> showNotification(@Param("account_id") long account_id);



}
