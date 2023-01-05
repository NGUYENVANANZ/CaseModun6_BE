package com.example.casemodun6_be.repository;

import com.example.casemodun6_be.model.DetailAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailAccountRepo extends CrudRepository<DetailAccount, Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM detail_account where status = 1 ORDER BY join_date DESC LIMIT 12")
    List<DetailAccount> findDetailNewbie();
}
