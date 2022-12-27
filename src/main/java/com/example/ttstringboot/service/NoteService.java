package com.example.ttstringboot.service;

import com.example.ttstringboot.infras.model.Note;
import com.example.ttstringboot.infras.model.TagNote;
import com.example.ttstringboot.repository.NoteRepository;
import com.example.ttstringboot.repository.TagNoteRepository;
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
    @Autowired
    TagNoteRepository tagNoteRepository;

    public String add(Long userid, Note obj) {
        long id = 0;
        Random r = new Random();
        while (thisRepository.existsById(id) || id<=0) {
            id = r.nextInt();
        }
        obj.setStoraged(false);
        obj.setDeleted(false);
        obj.setId(id);
        obj.setUserid(userid);
        thisRepository.insert(obj);
        log.info("Added new note: " + id);
        return "Add new successfully!";
    }

    public String replace(Long userid, Note obj) {
        if (thisRepository.existsById(obj.getId())) {
            Note o = thisRepository.findByUseridAndId(userid, obj.getId());
            o.setTitle(obj.getTitle());
            o.setContent(obj.getContent());
            o.setTagNoteId(obj.getTagNoteId());
            thisRepository.save(o);
            log.info("Updated note: " + obj.getId());
            return "Update successfully!";
        }
        log.error("Not found " + obj.getId());
        return "Not found!";
    }

    public Note get(long id) {
        return thisRepository.findById(id).get();
    }
    public Note getByUseridAndId(Long userid, long id) {
        return thisRepository.findByUseridAndId(userid, id);
    }

    public String remove(Long userid, long id) {
        if (thisRepository.existsByIdAndUserid(userid,id)) {
            thisRepository.deleteById(id);
            log.info("Deleted " + id);
            return "Deleted " + id;
        }
        log.error("Not found " + id);
        return "Not found!";
    }
    private void removeTagNoteDeleted(long id){
        Note n = thisRepository.findById(id).get();
        Note nt = n;
        for(int i=0;i<n.getTagNoteId().size();i++){
            if(!tagNoteRepository.existsById(n.getTagNoteId().get(i))){
                n.getTagNoteId().remove(i);
            }
        }
        if(nt.getTagNoteId().equals(n.getTagNoteId())){
            thisRepository.save(n);
        }
    }
    private void removeTagNoteDeleted(){
        List<Note> ln = thisRepository.findAll();
        for(Note n: ln){
            Note nt = n;
            for(int i=0;i<n.getTagNoteId().size();i++){
                if(!tagNoteRepository.existsById(n.getTagNoteId().get(i))){
                    n.getTagNoteId().remove(i);
                }
            }
            if(nt.getTagNoteId().equals(n.getTagNoteId())){
                thisRepository.save(n);
            }
        }
    }
    public List<Note> getList(Long userid) {
        removeTagNoteDeleted();
        return thisRepository.findAllByUserid(userid);
    }
    public List<Note> getListByTag(Long userid, long tagNoteId){
        removeTagNoteDeleted();
        return thisRepository.findAllByUseridAndTagNoteId(userid, tagNoteId);
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
