package com.example.ttstringboot.repository;

import com.example.ttstringboot.infras.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository  extends MongoRepository<Note, Long> {
    List<Note> findNoteByTagNoteIdContains(long tagNoteId);
}
