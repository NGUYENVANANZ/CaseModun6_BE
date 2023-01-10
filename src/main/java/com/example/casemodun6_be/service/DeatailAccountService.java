package com.example.casemodun6_be.service;


import com.example.casemodun6_be.model.DTO.DetailAccountSart;
import com.example.casemodun6_be.model.DTO.Hires;
import com.example.casemodun6_be.model.DTO.Sart;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.model.Employ;
import com.example.casemodun6_be.model.Provided;
import com.example.casemodun6_be.model.Roles;
import com.example.casemodun6_be.repository.DetailAccountRepo;
import com.example.casemodun6_be.repository.EmployRepo;
import com.example.casemodun6_be.repository.ISearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DeatailAccountService {

    @Autowired
    DetailAccountRepo detailAccountRepo;


    @Autowired
    EmployRepo employRepo;

    @Autowired
    ISearchRepo iSearchRepo;
    public List<DetailAccountSart> getAll() {
        return detailAccounts(detailAccountRepo.getAll());
    }

    public List<DetailAccountSart> search(String name) {
        return detailAccounts(iSearchRepo.findByName(name));
    }

    public List<DetailAccountSart> showNewbie() {
        List<DetailAccountSart> detailAccounts = detailAccounts(detailAccountRepo.findDetailNewbie());
        if (detailAccounts.size() > 12) {
            List<DetailAccountSart> detailAccountSarts = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                detailAccountSarts.add(detailAccounts.get(i));
            }
            return detailAccountSarts;
        }
        return detailAccounts;
    }

    public List<DetailAccountSart> showVip() {
        List<DetailAccountSart> detailAccounts = detailAccounts(detailAccountRepo.findDetailVip());
        if (detailAccounts.size() > 12) {
            List<DetailAccountSart> detailAccountSarts = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                detailAccountSarts.add(detailAccounts.get(i));
            }
            return detailAccountSarts;
        }
        return detailAccounts;
    }

    public List<DetailAccountSart> showGender(String gender) {
        List<DetailAccountSart> detailAccounts;

        if (gender.equals("Nu")) {
            detailAccounts = detailAccounts(detailAccountRepo.findDetailGender("Nam"));
        } else {
            detailAccounts = detailAccounts(detailAccountRepo.findDetailGender("Nu"));
        }

        if (detailAccounts.size() > 12) {
            List<DetailAccountSart> detailAccountSarts = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                detailAccountSarts.add(detailAccounts.get(i));
            }
            return detailAccountSarts;
        }
        return detailAccounts;
    }

    public List<Sart> showSart() {
        List<DetailAccountSart> detailAccounts = detailAccounts(detailAccountRepo.findDetailSart());
        List<Sart> sarts = new ArrayList<>();
        List<Double> sart = sart((List<DetailAccount>) detailAccountRepo.findAll());
        for (int i = 0; i < detailAccounts.size(); i++) {
            sarts.add(new Sart(detailAccounts.get(i), sart.get(i)));
        }
        Collections.sort(sarts, new Comparator<Sart>() {
            @Override
            public int compare(Sart o1, Sart o2) {
                return (int) (o2.getStar() - o1.getStar());
            }
        });

        if (sarts.size() > 6) {
            List<Sart> sarts1 = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                sarts1.add(sarts.get(i));
            }
            return sarts1;
        }

        return sarts;
    }


    public List<Hires> showHires() {
        List<Employ> employs = employRepo.findEmployHires();
        List<DetailAccount> detailAccounts = new ArrayList<>();
        for (int i = 0; i < employs.size(); i++) {
            detailAccounts.add(employs.get(i).getDetailAccount());
        }
        List<Hires> hires = new ArrayList<>();
        List<DetailAccountSart> detailAccountSarts = detailAccounts(detailAccounts);
        for (int i = 0; i < employs.size(); i++) {
            hires.add(new Hires(detailAccountSarts.get(i), employs.get(i).getHires()));
        }

        Collections.sort(hires, new Comparator<Hires>() {
            @Override
            public int compare(Hires o1, Hires o2) {
                return (int) (o2.getHires() - o1.getHires());
            }
        });

        return hires;
    }


    public List<Double> sart(List<DetailAccount> detailAccounts) {
        List<Double> doubles = new ArrayList<>();

        for (DetailAccount d : detailAccounts) {
            double x = 0;

            if (d.getComments().size() != 0) {
                for (int i = 0; i < d.getComments().size(); i++) {
                    x += d.getComments().get(i).getStar();
                }
                doubles.add(x / d.getComments().size());
            } else {
                doubles.add(0.0);
            }

        }

        return doubles;
    }


    public List<DetailAccountSart> detailAccounts(List<DetailAccount> detailAccounts1) {
        List<DetailAccountSart> detailAccounts = new ArrayList<>();
        for (DetailAccount d : detailAccounts1) {
            for (Roles r : d.getRoles()) {
                if (r.getId() == 3) {
                    DetailAccountSart detailAccount = new DetailAccountSart();
                    detailAccount.setId(d.getId());
                    detailAccount.setFullName(d.getFullName());
                    detailAccount.setMota(d.getMoTa());
                    detailAccount.setImg(d.getImg());
                    List<Provided> provideds = provideds(d.getProvideds());
                    detailAccount.setProvideds(provideds);
                    detailAccount.setPrice(d.getPricePerDay());
                    detailAccounts.add(detailAccount);
                }

            }
        }
        return detailAccounts;
    }

    public List<Provided> provideds(List<Provided> provideds) {
        List<Provided> provideds1 = new ArrayList<>();

        if (provideds.size() == 0) {
            return provideds1;
        }
        for (int i = 0; i < provideds.size(); i++) {
            provideds1.add(provideds.get(i));
            if (provideds1.size() == 3){
                break;
            }
        }
        return provideds1;
    }





}
