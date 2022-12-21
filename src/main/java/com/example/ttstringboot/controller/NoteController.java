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

    @RequestMapping( value = "/note/{id}", method = RequestMethod.GET)
    public Note getCustomer(@PathVariable long id){
        return thisService.get(id);
    }

    @RequestMapping(value="/note/list", method = RequestMethod.GET)
    public List<Note> getList(){
        return thisService.getList();
    }

    @RequestMapping(value="/note/{id}", method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable long id){
        return thisService.remove(id);
    }

    @RequestMapping(value="/note", method = RequestMethod.POST)
    public String addCustomer(@RequestBody Note note){
        return thisService.add(note);
    }

    @RequestMapping(value="/note", method = RequestMethod.PUT)
    public String editCustomer(@RequestBody Note note){
        return thisService.replace(note);
    }
    @RequestMapping(value="/note/list/{tagnote}", method = RequestMethod.GET)
    public List<Note> getListByTag(@PathVariable long tagnote){
        return thisService.getListByTag(tagnote);
    }
    @RequestMapping(value = "/note/removetagnoteid/{tagnote}", method = RequestMethod.PUT)
    public Note removeTagofNote(@PathVariable long tagnote, @RequestBody long note){
        return thisService.removeTagofNote(tagnote, note);
    }
}