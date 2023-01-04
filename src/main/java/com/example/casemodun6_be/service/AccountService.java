package com.example.casemodun6_be.service;

import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    IAccountRepo iAccountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.findByUsername(username);

        if (account != null) {
            return new User(account.getUsername(), account.getPassword(), account.getRoles());
        }
        return null;
    }

    public List<Account> getAll() {
        return (List<Account>) iAccountRepo.findAll();
    }

    public Account findByName(String name) {
        return iAccountRepo.findByUsername(name);
    }
    public Account findbysdt(String phoneNumber) {
        return iAccountRepo.findByPhoneNumber(phoneNumber);
    }


}
