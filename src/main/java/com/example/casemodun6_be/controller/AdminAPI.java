package com.example.casemodun6_be.controller;

import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.DTO.AccountDTO;
import com.example.casemodun6_be.model.DetailAccount;
import com.example.casemodun6_be.model.Roles;
import com.example.casemodun6_be.repository.*;
import com.example.casemodun6_be.service.AccountService;
import com.example.casemodun6_be.service.DeatailAccountService;
import com.example.casemodun6_be.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
public class AdminAPI {

    @Autowired
    AccountService accountService;

    @Autowired
    DeatailAccountService detailAccount;

    @Autowired
    IAccountRepo iAccountRepo;

    @Autowired
    IRoleRepo iRoleRepo;

    @Autowired
    AdminRepo adminRepo;
    @Autowired
    SendMailService sendMailService;
    @Autowired
    private RolesRepo rolesRepo;
    @Autowired
    private DetailAccountRepo detailAccountRepo;

    @GetMapping("/VipProMax/{vip}/{id}")
    public ResponseEntity<?> vip(@PathVariable long vip, @PathVariable long id) {
        DetailAccount detailAccount1 = accountService.finbyVip(vip, id);
        if (vip == 0) {
            detailAccount1.setVip(1);
            accountService.save(detailAccount1);
        } else if (vip == 1) {
            detailAccount1.setVip(0);
            accountService.save(detailAccount1);
        }
        return new ResponseEntity<>(detailAccount1, HttpStatus.OK);
    }

    @GetMapping("/lock/{id}")
    public ResponseEntity<List<AccountDTO>> lockroles2(@PathVariable long id) {
        Account account = accountService.finbyid(id);
        account.setStatus(0);
        iAccountRepo.save(account);
        List<Account> accounts = accountService.getAll();
        List<Account> accounts1 = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<Roles> roles = accounts.get(i).getDetailAccount().getRoles();
            for (int j = 0; j < roles.size(); j++) {
                if (accounts.get(i).getDetailAccount().getRoles().get(j).getId() == 2) {
                    accounts1.add(accounts.get(i));
                }
            }
        }
        List<AccountDTO> dtos = new ArrayList<>();
        for (int i = 0; i < accounts1.size(); i++) {
            AccountDTO accountDTO = new AccountDTO(accounts1.get(i).getId(), accounts1.get(i).getDetailAccount().getImg(), accounts1.get(i).getDetailAccount().getFullName(), accounts1.get(i).getDetailAccount().getMoTa(), accounts1.get(i).getStatus(), accounts1.get(i).getDetailAccount().getVip(), accounts1.get(i).getDetailAccount(), accounts1.get(i).getDetailAccount().getMoney());
            dtos.add(accountDTO);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


    @GetMapping("/unlock/{id}")
    public ResponseEntity<List<AccountDTO>> unlockroles2(@PathVariable long id) {
        Account account = accountService.finbyid(id);
        account.setStatus(1);
        iAccountRepo.save(account);
        List<Account> accounts = accountService.getAll();
        List<Account> accounts1 = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<Roles> roles = accounts.get(i).getDetailAccount().getRoles();
            for (int j = 0; j < roles.size(); j++) {
                if (accounts.get(i).getDetailAccount().getRoles().get(j).getId() == 2) {
                    accounts1.add(accounts.get(i));
                }
            }
        }
        List<AccountDTO> dtos = new ArrayList<>();
        for (int i = 0; i < accounts1.size(); i++) {
            AccountDTO accountDTO = new AccountDTO(accounts1.get(i).getId(), accounts1.get(i).getDetailAccount().getImg(), accounts1.get(i).getDetailAccount().getFullName(), accounts1.get(i).getDetailAccount().getMoTa(), accounts1.get(i).getStatus(), accounts1.get(i).getDetailAccount().getVip(), accounts1.get(i).getDetailAccount(), accounts1.get(i).getDetailAccount().getMoney());
            dtos.add(accountDTO);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


    @GetMapping("/lock1/{id}")
    public ResponseEntity<List<AccountDTO>> lockroles3(@PathVariable long id) {
        Account account = accountService.finbyid(id);
        account.setStatus(0);
        iAccountRepo.save(account);
        List<Account> accounts = accountService.getAll();
        List<Account> accounts1 = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<Roles> roles = accounts.get(i).getDetailAccount().getRoles();
            for (int j = 0; j < roles.size(); j++) {
                if(accounts.get(i).getDetailAccount().getRoles().get(j).getId()==3){
                    accounts1.add(accounts.get(i));
                }
            }
        }
        List<AccountDTO> dtos = new ArrayList<>();
        for (int i = 0; i < accounts1.size(); i++) {
            AccountDTO accountDTO = new AccountDTO(accounts1.get(i).getId(), accounts1.get(i).getDetailAccount().getImg(), accounts1.get(i).getDetailAccount().getFullName(), accounts1.get(i).getDetailAccount().getMoTa(), accounts1.get(i).getStatus(), accounts1.get(i).getDetailAccount().getVip(), accounts1.get(i).getDetailAccount(), accounts1.get(i).getDetailAccount().getMoney());
            dtos.add(accountDTO);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


    @GetMapping("/unlock1/{id}")
    public ResponseEntity<List<AccountDTO>> unlockroles3(@PathVariable long id) {
        Account account = accountService.finbyid(id);
        account.setStatus(1);
        iAccountRepo.save(account);
        List<Account> accounts = accountService.getAll();
        List<Account> accounts1 = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<Roles> roles = accounts.get(i).getDetailAccount().getRoles();
            for (int j = 0; j < roles.size(); j++) {
                if(accounts.get(i).getDetailAccount().getRoles().get(j).getId()==3){
                    accounts1.add(accounts.get(i));
                }
            }
        }
        List<AccountDTO> dtos = new ArrayList<>();
        for (int i = 0; i < accounts1.size(); i++) {
            AccountDTO accountDTO = new AccountDTO(accounts1.get(i).getId(), accounts1.get(i).getDetailAccount().getImg(), accounts1.get(i).getDetailAccount().getFullName(), accounts1.get(i).getDetailAccount().getMoTa(), accounts1.get(i).getStatus(), accounts1.get(i).getDetailAccount().getVip(), accounts1.get(i).getDetailAccount(), accounts1.get(i).getDetailAccount().getMoney());
            dtos.add(accountDTO);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping("/vip")
    public ResponseEntity<DetailAccount> vip(@PathVariable long vip){
        DetailAccount detailAccount1 = accountService.finbyid(vip).getDetailAccount();
        detailAccount1.setVip(1);
        return new ResponseEntity<>(detailAccount1, HttpStatus.OK);
    }


    @GetMapping("/GetallAccountByRoles2")
    public ResponseEntity<List<AccountDTO>> Accounts() {
        List<Account> accounts = accountService.getAll();
        List<Account> accounts1 = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<Roles> roles = accounts.get(i).getDetailAccount().getRoles();
            for (int j = 0; j < roles.size(); j++) {
                if (accounts.get(i).getDetailAccount().getRoles().get(j).getId() == 2) {
                    accounts1.add(accounts.get(i));
                }
            }
        }
        List<AccountDTO> dtos = new ArrayList<>();
        for (int i = 0; i < accounts1.size(); i++) {
            AccountDTO accountDTO = new AccountDTO(accounts1.get(i).getId(), accounts1.get(i).getDetailAccount().getImg(), accounts1.get(i).getDetailAccount().getFullName(), accounts1.get(i).getDetailAccount().getMoTa(), accounts1.get(i).getStatus(), accounts1.get(i).getDetailAccount().getVip(), accounts1.get(i).getDetailAccount(), accounts1.get(i).getDetailAccount().getMoney());
            dtos.add(accountDTO);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/GetallAccountByRoles3")
    public ResponseEntity<List<AccountDTO>> Accountsrole3() {
        List<Account> accounts = accountService.getAll();
        List<Account> accounts1 = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<Roles> roles = accounts.get(i).getDetailAccount().getRoles();
            for (int j = 0; j < roles.size(); j++) {
                if (accounts.get(i).getDetailAccount().getRoles().get(j).getId() == 3) {
                    accounts1.add(accounts.get(i));
                }
            }
        }
        List<AccountDTO> dtos = new ArrayList<>();
        for (int i = 0; i < accounts1.size(); i++) {
            AccountDTO accountDTO = new AccountDTO(accounts1.get(i).getId(), accounts1.get(i).getDetailAccount().getImg(), accounts1.get(i).getDetailAccount().getFullName(), accounts1.get(i).getDetailAccount().getMoTa(), accounts1.get(i).getStatus(), accounts1.get(i).getDetailAccount().getVip(), accounts1.get(i).getDetailAccount(), accounts1.get(i).getDetailAccount().getMoney());
            dtos.add(accountDTO);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/recharge/{id}/{money}")
    public ResponseEntity<?> NapTien(@PathVariable long id, @PathVariable long money) {
        DetailAccount detailAccount1 = accountService.finbyidhihi(id);
        long Moneyhihi = detailAccount1.getMoney();
             Moneyhihi += money;
            detailAccount1.setMoney(Moneyhihi);
            accountService.save(detailAccount1);
        return new ResponseEntity<>(detailAccount1, HttpStatus.OK);
    }
    @PostMapping("/confirm/{id}")
    public ResponseEntity<?> confirmEnterprise(@PathVariable int id) {
        String password = sendMailService.createCode();//tạo ra password
        DetailAccount detailAccount1 = new DetailAccount();
        String mail = accountService.finbyid(id).getEmail(); //lấy email theo id đối tượng
        sendMailService.sendMail(mail, "Thông tin xác thực", "Việc làm  24 đã xác thực yêu cầu của bạn :\n\t\t- Mật khẩu :" + password + "\nLưu ý  :" +
                "\n\t\t\t - Để bảo mật đổi mật khẩu ứng dụng trước khi sử dụng ! \n\t Xin cảm ơn !");//tạo email
        accountService.confirmRegisterAccount(password ,1,id);//mã code status 1 id của đối tượng
        Account account = new Account();//tạo 1 user moiws
        account.setUsername(accountService.finbyid(id).getEmail());//
//        Chỉnh sửa password
        account.setPassword(password);
        account.setEmail(accountService.finbyid(id).getEmail());
        List<Roles>roles=new ArrayList<>();
        roles.add(rolesRepo.findById(2L).get());
        detailAccount1.setRoles(roles);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/refuseConfirm/{id}/{reasonRefuse}")
    public ResponseEntity<?> refuseConfirmEnterprise(@PathVariable int id, @PathVariable String reasonRefuse) {
        String mail = accountService.finbyid(id).getEmail();
        sendMailService.sendMail(mail, "Thông báo ", "Việc làm  24 thông báo :\n\t\t\t Công ty của bạn không đủ điều kiện để chúng tôi xác thực !\n\t\t\tLý do : " + reasonRefuse + "\n\t\tXin cảm ơn !");
        accountService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}