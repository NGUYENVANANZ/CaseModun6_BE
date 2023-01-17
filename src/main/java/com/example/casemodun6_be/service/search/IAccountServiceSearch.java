package com.example.casemodun6_be.service.search;

import com.example.casemodun6_be.model.DetailAccount;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public interface IAccountServiceSearch extends ICRUD_Service<DetailAccount> {
    List<DetailAccount> findByName(String name);

    List<DetailAccount> searchByAll(String gender, long birthday, String city);

}
