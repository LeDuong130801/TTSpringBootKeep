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

    @RequestMapping( value = "/tagnote/{userid}/{id}", method = RequestMethod.GET)
    public TagNote get(@PathVariable Long userid,@PathVariable long id){
        return tagNoteService.getByUseridAndId(userid, id);
    }

    @RequestMapping(value="/tagnote/{userid}/list", method = RequestMethod.GET)
    public List<TagNote> getList(@PathVariable Long userid){
        return tagNoteService.getList(userid);
    }

    @RequestMapping(value="/tagnote/{userid}/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable long id, @PathVariable Long userid){
        return tagNoteService.remove(userid, id);
    }

    @RequestMapping(value="/tagnote/{userid}", method = RequestMethod.POST)
    public String add(@RequestBody TagNote tagNote, @PathVariable Long userid){
        return tagNoteService.add(userid, tagNote);
    }

    @RequestMapping(value="/tagnote/{userid}", method = RequestMethod.PUT)
    public String edit(@RequestBody TagNote tagNote, @PathVariable Long userid){
        return tagNoteService.replace(userid, tagNote);
    }
}
