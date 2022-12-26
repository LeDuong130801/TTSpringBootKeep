package com.example.ttstringboot.infras.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    Long id;
    String username;
    String password;
}
