package com.example.ttstringboot.infras.model;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    @Id
    private long id;
    private String name;
    private int age;

}
