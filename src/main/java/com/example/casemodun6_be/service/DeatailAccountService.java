package com.example.casemodun6_be.service;

import com.example.casemodun6_be.model.*;
import com.example.casemodun6_be.model.DTO.DetailAccountSart;
import com.example.casemodun6_be.model.DTO.Hires;
import com.example.casemodun6_be.model.DTO.Sart;
import com.example.casemodun6_be.repository.DetailAccountRepo;
import com.example.casemodun6_be.repository.EmployRepo;
import com.example.casemodun6_be.repository.ISearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

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
        for (int i = 0; i < detailAccounts.size(); i++) {
            sarts.add(new Sart(detailAccounts.get(i), sart(detailAccounts.get(i).getId())));
        }
        Collections.sort(sarts, new Comparator<Sart>() {
            @Override
            public int compare(Sart o1, Sart o2) {
                if (o2.getStar() - o1.getStar() > 0) {
                    return 1;
                } else if (o2.getStar() - o1.getStar() == 0) {
                    return 0;
                } else {
                    return -1;
                }

            }
        });

        if (sarts.size() > 3) {
            List<Sart> sarts1 = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
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

//    public DetailAccount ShowComment(long detail_account_id) {
//        List<Comment> comments = detailAccountRepo.finAllComt(detail_account_id);
//        List<DetailAccount> detailAccounts = new ArrayList<>();
//        for (int i = 0; i < comments.size(); i++) {
//              detailAccounts.add(detailAccounts.get(i).getId(),detailAccounts.get(i).getFullName(),comments.get(i).getText(),comments.get(i).getStar())
//        }
//        return
//    }


    public Double sart(long id) {
        DetailAccount detailAccount = detailAccountRepo.findById(id).get();
        double ketQua = 0;
        double x = 0;
        if (detailAccount.getComments().size() != 0) {
            for (int i = 0; i < detailAccount.getComments().size(); i++) {
                x += detailAccount.getComments().get(i).getStar();
            }
            ketQua = x / detailAccount.getComments().size();
        }
        return ketQua;
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
                    detailAccount.setGender(d.getGender());
                    detailAccount.setBirthday(d.getBirthday());
                    detailAccount.setCity(d.getCity());
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
            if (provideds1.size() == 3) {
                break;
            }
        }
        return provideds1;
    }
}
