package com.example.casemodun6_be.service;

import com.example.casemodun6_be.model.Account;

import java.util.List;

public interface IAccountService {


        void save(Account account);


        List<Account > findAll();

        void editProfile (Account account);


        List<Account> getAllAccount();

        List<Account> getAllAccountNotConfirmOrderByTime();
        List<Account> getAllAccountConfirmOrderByTime();


        Account findAccountById(int id);

        Account findByGmailAccount(String name);


        void confirmRegisterAccount(String password ,int status, int id);

        void delete(int id);



//    List<Enterprise> listEnterpriseOderByRates();



        void setStatusAccountTo1(int id);
        void setStatusAccountTo0(int id);





        void changPassword(String email, String password);





    }


