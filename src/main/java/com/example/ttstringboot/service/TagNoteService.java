package com.example.ttstringboot.service;

import com.example.ttstringboot.infras.model.Note;
import com.example.ttstringboot.infras.model.TagNote;
import com.example.ttstringboot.infras.model.TagNote;
import com.example.ttstringboot.repository.TagNoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class TagNoteService {
    @Autowired
    TagNoteRepository thisRepository;

    public String add(Long userid, TagNote obj) {
        long id = 0;
        Random r = new Random();
        while (thisRepository.existsById(id) || id<=0){
            id = r.nextInt();
        }
        obj.setUserid(userid);
        obj.setId(id);
        thisRepository.insert(obj);
        log.info("Added "+id);
        return "Add new successfully!";
    }

    public String replace(Long userid, TagNote obj){
        if(thisRepository.existsByUseridAndId(userid, obj.getId())){
            TagNote o = thisRepository.findByUseridAndId(userid, obj.getId());
            o.setTitle(obj.getTitle());
            thisRepository.save(o);
            log.info("Updated "+obj.getId());
            return "Update successfully!";
        }
        log.error("Not found "+obj.getId());
        return "Not found!";
    }

    public TagNote get(long id){
        return thisRepository.findById(id).get();
    }
    public TagNote getByUseridAndId(Long userid, long id) {
        return thisRepository.findByUseridAndId(userid, id);
    }
    public String remove(Long userid, long id){
        if(thisRepository.existsByUseridAndId(userid, id)){
            thisRepository.deleteById(id);
            log.info("Deleted "+id);
            return "Deleted "+id;
        }
        log.error("Not found "+id);
        return "Not found!";
    }

    public List<TagNote> getList(Long userid) {
        return thisRepository.findAllByUserid(userid);
    }
}
