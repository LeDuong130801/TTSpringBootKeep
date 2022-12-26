package com.example.ttstringboot.repository;

import com.example.ttstringboot.infras.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository  extends MongoRepository<Note, Long> {
    List<Note> findNoteByTagNoteIdContains(long tagNoteId);
    List<Note> findAllByUserid(Long userid);
    List<Note> findAllByUseridAndTagNoteId(Long userid, Long tagNoteId);
    boolean existsByIdAndUserid(Long userid, Long id);
    Note findByUseridAndId(Long userid, Long Id);
}
