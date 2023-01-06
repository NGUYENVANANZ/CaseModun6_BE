package com.example.casemodun6_be.repository;

import com.example.casemodun6_be.model.DTO.Hires;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.model.Employ;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployRepo extends CrudRepository<Employ, Long> {
    @Query(nativeQuery = true,value = "SELECT employ.id, employ.account_id, employ.detail_account_id, sum(employ.hires) as hires FROM employ GROUP BY detail_account_id ORDER BY hires DESC")
    List<Employ> findEmployHires();

}
