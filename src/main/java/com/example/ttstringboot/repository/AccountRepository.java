package com.example.ttstringboot.repository;

import com.example.ttstringboot.infras.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, Long> {

    public boolean existsAccountByUsernameAndPassword(String username, String password);
    public boolean existsAccountByUsername(String username);
    public Account getAccountByUsernameAndPassword(String username, String password);
    public Account findByUsername(String username);
}
