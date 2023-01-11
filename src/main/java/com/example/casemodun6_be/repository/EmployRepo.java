package com.example.casemodun6_be.repository;

import com.example.casemodun6_be.model.DTO.Hires;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.model.Employ;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployRepo extends CrudRepository<Employ, Long> {
    @Query(nativeQuery = true,value = "SELECT employ.id, employ.account_id, employ.detail_account_id, sum(employ.hires) as hires  , employ.date, employ.money FROM employ GROUP BY detail_account_id ORDER BY hires DESC limit 3")
    List<Employ> findEmployHires();

    @Query(nativeQuery = true,value = "SELECT employ.id, employ.account_id, employ.detail_account_id, sum(employ.hires) as hires  , employ.date, employ.money FROM employ where detail_account_id = :detail_account_id")
    Employ findEmploy(@Param("detail_account_id")long detail_account_id);

    @Query(nativeQuery = true,value = "SELECT * FROM employ where account_id = :account_id  ORDER BY date DESC ")
    List<Employ> showEmploy(@Param("account_id") long account_id);
}
