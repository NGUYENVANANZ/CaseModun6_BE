package com.example.casemodun6_be.service;

import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.model.Provided;
import com.example.casemodun6_be.repository.DetailAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class DeatailAccountService {

    @Autowired
    DetailAccountRepo detailAccountRepo;

    public List<DetailAccount> showNewbie() {
        List<DetailAccount> detailAccounts = detailAccounts(detailAccountRepo.findDetailNewbie());
        return detailAccounts;
    }

    public List<DetailAccount> detailAccounts(List<DetailAccount> detailAccounts1) {
        List<DetailAccount> detailAccounts = new ArrayList<>();
        for (DetailAccount d : detailAccounts1) {
            DetailAccount detailAccount = new DetailAccount();
            detailAccount.setId(d.getId());
            detailAccount.setCity(d.getCity());
            detailAccount.setNation(d.getNation());

            detailAccount.setHeight(d.getHeight());
            detailAccount.setWeight(d.getWeight());

            detailAccount.setSoThich(d.getSoThich());
            detailAccount.setMoTa(d.getMoTa());
            detailAccount.setYeuCau(d.getYeuCau());

            detailAccount.setFullName(d.getFullName());
            detailAccount.setBirthday(d.getBirthday());
            detailAccount.setJoinDate(d.getJoinDate());

            detailAccount.setImg(d.getImg());
            detailAccount.setImgs(d.getImgs());

            List<Provided> provideds = provideds(d.getProvideds());
            detailAccount.setProvideds(provideds);

            detailAccount.setPricePerDay(d.getPricePerDay());
            detailAccount.setFaceLink(d.getCity());
            detailAccount.setStatus(d.isStatus());

            detailAccounts.add(detailAccount);
        }
        return detailAccounts;
    }

    public List<Provided> provideds(List<Provided> provideds) {
        List<Provided> provideds1 = new ArrayList<>();

        if (provideds.size() == 0) {
            return provideds1;
        }
        List<Integer> randomInt = random(provideds.size() - 1);
        for (int i = 0; i < randomInt.size(); i++) {
            provideds1.add(provideds.get(randomInt.get(i)));
        }
        return provideds1;
    }

    public List<Integer> random(int number) {
        Random random = new Random();
        List<Integer> randomNumbers = random.ints(0, number).distinct().limit(3).boxed().collect(Collectors.toList());
        return randomNumbers;
    }
}
