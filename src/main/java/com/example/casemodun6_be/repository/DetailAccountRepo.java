package com.example.casemodun6_be.repository;

import com.example.casemodun6_be.model.DetailAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailAccountRepo extends CrudRepository<DetailAccount, Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM detail_account where status = 1 ORDER BY join_date DESC")
    List<DetailAccount> findDetailNewbie();

    @Query(nativeQuery = true,value = "SELECT * FROM detail_account where vip = 1 and status = 1 ORDER BY join_date DESC")
    List<DetailAccount> findDetailVip();

    @Query(nativeQuery = true,value = "SELECT * FROM detail_account where detail_account.status = 1")
    List<DetailAccount> findDetailSart();

    @Query(nativeQuery = true,value = "SELECT * FROM detail_account where gender =:gender and status = 1 ORDER BY join_date DESC")
    List<DetailAccount> findDetailGender(@Param("gender") String gender);

    @Query(nativeQuery = true,value = "SELECT * FROM detail_account where status = 1 ORDER BY join_date DESC")
    List<DetailAccount> getAll();
    @Query(nativeQuery = true,value = "SELECT * FROM detail_account where gender =:gender and status = 1 ")
    List<DetailAccount> findAllDetailGender(String gender);

    @Query(nativeQuery = true,value = "SELECT distinct gender FROM detail_account where  status = 1 ")
    List<String> findAllGender();
}
