package com.example.casemodun6_be.repository;

import com.example.casemodun6_be.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AdminRepo extends JpaRepository<Account,Integer> {
    @Query(value = "group by Account.account_id limit ?1,5;", nativeQuery = true)
    List<Account> getAllBy(int index);
}
