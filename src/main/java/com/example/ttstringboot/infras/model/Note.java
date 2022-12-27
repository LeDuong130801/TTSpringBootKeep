package com.example.ttstringboot.infras.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Note {
    @Id
    long id;
    String title;
    String content;
    List<Long> tagNoteId;
    Long userid;
//    boolean isStoraged;
//    boolean isDeleted;
//    String tagNoteId;
}

