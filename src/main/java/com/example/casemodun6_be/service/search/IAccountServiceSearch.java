package com.example.casemodun6_be.service.search;

import com.example.casemodun6_be.model.DetailAccount;

import java.time.LocalDate;
import java.util.List;

public interface IAccountServiceSearch extends ICRUD_Service<DetailAccount> {
    List<DetailAccount> findByName(String name);

    Iterable<DetailAccount> searchByAll(long status, String gender, LocalDate birthday,String city,long hires);
}
