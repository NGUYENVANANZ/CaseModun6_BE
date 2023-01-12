package com.example.casemodun6_be.repository;

import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DetailAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AdminRepo extends JpaRepository<Account,Long> {
    @Query(value = "group by Account.account_id limit ?1,5;", nativeQuery = true)
    List<Account> getAllBy(int index);

    @Query(nativeQuery = true,value = "SELECT * from account")
    List<Account> getAll();

   @Query(nativeQuery = true, value = "SELECT * from dettailAccount where id = :id")
   DetailAccount findByIdhi(@Param("id") long id);

}