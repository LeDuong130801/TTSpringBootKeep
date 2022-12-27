package com.example.ttstringboot.service;

import com.example.ttstringboot.infras.model.Account;
import com.example.ttstringboot.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class AccountService {
    @Autowired
    AccountRepository thisRepository;
    public Long Login(Account account){
        if(thisRepository.existsAccountByUsername(account.getUsername())){
            return thisRepository.findByUsername(account.getUsername()).getId();
        }
        return 0L;
    }
    public String Signup(Account acc){
        long id = 0;
        Random r = new Random();
        if(thisRepository.existsAccountByUsername(acc.getUsername())){
            return "Tai khoan "+acc.getUsername()+" da ton tai";
        }
        while (thisRepository.existsById(id) || id<=0){
            id = r.nextInt();
        }
        acc.setId(id);
        thisRepository.insert(acc);
        log.info("Added "+id);
        return "Add new successfully!";
    }
    public List<Account> getList() {
        return thisRepository.findAll();
    }
}
