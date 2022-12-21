package com.example.ttstringboot.controller;

import com.example.ttstringboot.infras.model.TagNote;
import com.example.ttstringboot.service.TagNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagNoteController {
    @Autowired
    TagNoteService tagNoteService;

    @RequestMapping( value = "/tagnote/{id}", method = RequestMethod.GET)
    public TagNote get(@PathVariable long id){
        return tagNoteService.get(id);
    }

    @RequestMapping(value="/tagnote/list", method = RequestMethod.GET)
    public List<TagNote> getList(){
        return tagNoteService.getList();
    }

    @RequestMapping(value="/tagnote/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable long id){
        return tagNoteService.remove(id);
    }

    @RequestMapping(value="/tagnote", method = RequestMethod.POST)
    public String add(@RequestBody TagNote tagNote){
        return tagNoteService.add(tagNote);
    }

    @RequestMapping(value="/tagnote", method = RequestMethod.PUT)
    public String edit(@RequestBody TagNote tagNote){
        return tagNoteService.replace(tagNote);
    }
}
