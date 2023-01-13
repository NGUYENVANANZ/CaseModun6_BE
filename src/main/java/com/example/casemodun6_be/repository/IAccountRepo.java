package com.example.casemodun6_be.repository;


import com.example.casemodun6_be.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepo extends CrudRepository<Account, Long> {

    @Query(nativeQuery = true,value = "SELECT * from account where phone_number = :phoneNumber")
    Account findByPhoneNumber(String phoneNumber);

    Account findByUsername(String username);

    @Query(nativeQuery = true,value = "SELECT * from account where id = :id")
    Account findById(@Param("id") long id);


}