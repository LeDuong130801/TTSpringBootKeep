package com.example.ttstringboot.service;

import com.example.ttstringboot.infras.model.Note;
import com.example.ttstringboot.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class NoteService {
    @Autowired
    NoteRepository thisRepository;

    public String add(Note obj) {
        long id = 0;
        Random r = new Random();
        while (thisRepository.existsById(id) || id<=0) {
            id = r.nextInt();
        }
        obj.setId(id);
        thisRepository.insert(obj);
        log.info("Added " + id);
        return "Add new successfully!";
    }

    public String replace(Note obj) {
        if (thisRepository.existsById(obj.getId())) {
            Optional<Note> o = thisRepository.findById(obj.getId());
            o.get().setTitle(obj.getTitle());
            o.get().setContent(obj.getContent());
            o.get().setTagNoteId(obj.getTagNoteId());
            thisRepository.save(o.get());
            log.info("Updated " + obj.getId());
            return "Update successfully!";
        }
        log.error("Not found " + obj.getId());
        return "Not found!";
    }

    public Note get(long id) {
        return thisRepository.findById(id).get();
    }

    public String remove(long id) {
        if (thisRepository.existsById(id)) {
            thisRepository.deleteById(id);
            log.info("Deleted " + id);
            return "Deleted " + id;
        }
        log.error("Not found " + id);
        return "Not found!";
    }

    public List<Note> getList() {
        return thisRepository.findAll();
    }
    public List<Note> getListByTag(long tagNoteId){
        return thisRepository.findNoteByTagNoteIdContains(tagNoteId);
    }
    public Note removeTagofNote(long tagNoteId, long noteid){
        Note note = thisRepository.findById(noteid).get();
        List<Long> l = note.getTagNoteId();
        for(int i=0;i<l.size();i++){
            if(l.get(i)==tagNoteId){
                l.remove(i);
            }
        }
        note.setTagNoteId(l);
        return thisRepository.save(note);
    }
}
