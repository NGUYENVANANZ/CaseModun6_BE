package com.example.casemodun6_be.service.search;

import com.example.casemodun6_be.model.DetailAccount;

import java.util.List;

public interface IAccountServiceSearch extends ICRUD_Service<DetailAccount> {
    List<DetailAccount> findByName(String name);
}
