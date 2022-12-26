package com.example.ttstringboot.controller;

import com.example.ttstringboot.infras.model.Note;
import com.example.ttstringboot.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/Note")
public class NoteController {
    @Autowired
    NoteService thisService;

    @RequestMapping( value = "/note/{userid}/{id}", method = RequestMethod.GET)
    public Note getCustomer(@PathVariable long id, @PathVariable Long userid){
        return thisService.getByUseridAndId(userid, id);
    }

    @RequestMapping(value="/note/{userid}/list", method = RequestMethod.GET)
    public List<Note> getList(@PathVariable Long userid){
        return thisService.getList(userid);
    }

    @RequestMapping(value="/note/{userid}/{id}", method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable long id, @PathVariable Long userid){
        return thisService.remove(userid, id);
    }

    @RequestMapping(value="/note/{userid}", method = RequestMethod.POST)
    public String addCustomer(@RequestBody Note note, @PathVariable Long userid){
        return thisService.add(userid, note);
    }

    @RequestMapping(value="/note/{userid}", method = RequestMethod.PUT)
    public String editCustomer(@RequestBody Note note, @PathVariable Long userid){
        return thisService.replace(userid, note);
    }
    @RequestMapping(value="/note/{userid}/list/{tagnote}", method = RequestMethod.GET)
    public List<Note> getListByTag(@PathVariable long tagnote, @PathVariable Long userid){
        return thisService.getListByTag(userid, tagnote);
    }
    @RequestMapping(value = "/note/removetagnoteid/{tagnote}", method = RequestMethod.PUT)
    public Note removeTagofNote(@PathVariable long tagnote, @RequestBody long note){
        return thisService.removeTagofNote(tagnote, note);
    }
}