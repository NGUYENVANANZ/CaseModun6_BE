package com.example.casemodun6_be.repository;

import com.example.casemodun6_be.model.DetailAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProfileRepo extends CrudRepository<DetailAccount,Long> {
    @Query(nativeQuery = true,value = "SELECT * from detail_account where id = :id ORDER BY date DESC")
    List<DetailAccount> showProfile(@Param("id")long id);


    @Query(nativeQuery = true,value = "SELECT * from detail_account where detail_account_id = :id ORDER BY date DESC")
    DetailAccount getaccountdetail(long id);
    DetailAccount findByFullName(String fullName);
    DetailAccount findDetailAccountById(long id);
}
