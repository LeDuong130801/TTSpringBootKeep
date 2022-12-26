package com.example.ttstringboot.repository;

import com.example.ttstringboot.infras.model.TagNote;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TagNoteRepository  extends MongoRepository<TagNote, Long> {
    boolean existsByUseridAndId(Long userid, Long id);
    List<TagNote> findAllByUserid(Long userid);
    TagNote findByUseridAndId(Long userid, Long id);
}