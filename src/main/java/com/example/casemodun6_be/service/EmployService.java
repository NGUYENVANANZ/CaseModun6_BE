package com.example.casemodun6_be.service;

import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DTO.DetailAccountSart;
import com.example.casemodun6_be.model.DTO.EmployDTO;
import com.example.casemodun6_be.model.DTO.Hires;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.model.Employ;
import com.example.casemodun6_be.model.Provided;
import com.example.casemodun6_be.repository.DetailAccountRepo;
import com.example.casemodun6_be.repository.EmployRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployService {

    @Autowired
    EmployRepo employRepo;

    @Autowired
    DetailAccountRepo detailAccountRepo;

    @Autowired
    DeatailAccountService deatailAccountService;

    @Autowired
    AccountService accountService;

    public List<EmployDTO> showEmloy(long id) {
        List<EmployDTO> employDTOS = new ArrayList<>();
        List<Employ> employs = employRepo.showEmploy(id);

        for (Employ e : employs) {
            employDTOS.add(new EmployDTO(e.getDetailAccount().getFullName(), e.getDetailAccount().getImg(), e.getDate(), e.getMoney()));
        }

        return employDTOS;
    }

    public Hires returnEmploy(long id) {
        Employ employ = employRepo.findEmploy(id);
        if (employ == null) {
            return new Hires();
        }
        DetailAccount detailAccount = employ.getDetailAccount();
        DetailAccountSart detailAccountSart = new DetailAccountSart();
        detailAccountSart.setId(detailAccount.getId());
        detailAccountSart.setFullName(detailAccount.getFullName());
        detailAccountSart.setMota(detailAccount.getMoTa());
        detailAccountSart.setImg(detailAccount.getImg());
        detailAccountSart.setProvideds(detailAccount.getProvideds());
        detailAccountSart.setPrice(detailAccount.getPricePerDay());

        Hires hires = new Hires(detailAccountSart, employ.getHires());
        return hires;
    }

    public void saveEmploy(long idAccount, long idDetail, long money) {
        Account account = accountService.finbyid(idAccount);
        DetailAccount detailAccount = detailAccountRepo.findById(idDetail).get();
        Employ employ = new Employ();
        employ.setAccount(account);
        employ.setDetailAccount(detailAccount);
        employ.setDate(LocalDate.now());
        employ.setMoney(money);
        employ.setHires(1);
        employRepo.save(employ);
    }
}
