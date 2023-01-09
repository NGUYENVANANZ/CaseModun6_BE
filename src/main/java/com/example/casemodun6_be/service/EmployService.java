package com.example.casemodun6_be.service;

import com.example.casemodun6_be.model.DTO.EmployDTO;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.model.Employ;
import com.example.casemodun6_be.repository.DetailAccountRepo;
import com.example.casemodun6_be.repository.EmployRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployService {

    @Autowired
    EmployRepo employRepo;

    @Autowired
    DetailAccountRepo detailAccountRepo;

    public List<EmployDTO> showEmloy(long id) {
        List<EmployDTO> employDTOS = new ArrayList<>();
        List<Employ> employs = employRepo.showEmploy(id);

        for (Employ e : employs) {
            employDTOS.add(new EmployDTO(e.getDetailAccount().getFullName(), e.getDetailAccount().getImg(), e.getDate(), e.getMoney()));
        }

        return employDTOS;
    }
}
