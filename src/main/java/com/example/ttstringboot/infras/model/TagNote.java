package com.example.ttstringboot.infras.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Getter
@Setter
public class TagNote {
    @Id
    long id;
    String title;
    Long userid;
}
