package com.example.ttstringboot.repository;

import com.example.ttstringboot.infras.model.TagNote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagNoteRepository  extends MongoRepository<TagNote, Long> {

}