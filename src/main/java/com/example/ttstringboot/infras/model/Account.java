package com.example.ttstringboot.infras.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {
    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }
    String username;
    String password;
}
