package com.example.ttstringboot.controller;

import com.example.ttstringboot.infras.model.Account;
import com.example.ttstringboot.infras.model.Note;
import com.example.ttstringboot.repository.AccountRepository;
import com.example.ttstringboot.service.AccountService;
import com.example.ttstringboot.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class AccountController  {
    @Autowired
    AccountService thisService;

    @RequestMapping( value = "/account", method = RequestMethod.PUT)
    public Long Login(@RequestBody Account account){
        return thisService.Login(account);
    }

    @RequestMapping(value="/account/list", method = RequestMethod.GET)
    public List<Account> getList(){
        return thisService.getList();
    }

//    @RequestMapping(value="/note/{id}", method = RequestMethod.DELETE)
//    public String deleteCustomer(@PathVariable long id){
//        return thisService.remove(id);
//    }

    @RequestMapping(value="/account", method = RequestMethod.POST)
    public String Signup(@RequestBody Account acc){
        return thisService.Signup(acc);
    }

//    @RequestMapping(value="/note", method = RequestMethod.PUT)
//    public String editCustomer(@RequestBody Note note){
//        return thisService.replace(note);
//    }
//    @RequestMapping(value="/note/list/{tagnote}", method = RequestMethod.GET)
//    public List<Note> getListByTag(@PathVariable long tagnote){
//        return thisService.getListByTag(tagnote);
//    }
//    @RequestMapping(value = "/note/removetagnoteid/{tagnote}", method = RequestMethod.PUT)
//    public Note removeTagofNote(@PathVariable long tagnote, @RequestBody long note){
//        return thisService.removeTagofNote(tagnote, note);
//    }
}