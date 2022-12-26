package com.example.ttstringboot.controller;

import com.example.ttstringboot.infras.model.Account;
import com.example.ttstringboot.infras.model.Customer;
import com.example.ttstringboot.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/Account")
public class IndexController {


    ArrayList<Account> listAccount = new ArrayList<>();

    @Autowired
    CustomerService customerService;




//    /**
//     * Giá trị trong getMapping: đường dẫn để chạy hàm này
//     * value=name: name là cái viết trên url sau dấu ?
//     * RequestParam: ?name=tenCuaBan
//     * RequestBody: giá trị truyền vào là json
//     */
//    @GetMapping("/sendName")
//    public String getText(@RequestParam(value="name", defaultValue = "Dương")String tenCuaBan){
//        log.info("ten: "+tenCuaBan);
//        return "<script sync>alert('Vừa truyền vào tên: "+tenCuaBan+"');</script>";
//    }

//    @GetMapping("/findAccount")
//    public void findAccount(@RequestParam(value="username", defaultValue = "")String username,
//                           @RequestParam(value="password", defaultValue = "1")String password){
//        if(listAccount.contains(new Account(username, password))){
//            log.info("Có tài khoản này");
//        }
//        else {
//            log.error("Sai tài khoản hoặc mật khẩu");
//        }
//    }
//    @PostMapping("/createAccount")
//    public void createAccount(@RequestParam(value="username", defaultValue = "")String username,
//                              @RequestParam(value="password", defaultValue = "1")String password){
//        for (Account account : listAccount){
//            if(account.getUsername().equals(username)){
//                log.error("Tài khoản này đã tồn tại");
//                return;
//            }
//        }
//        Account a = new Account(username, password);
//        listAccount.add(a);
//        log.info("Tạo tài khoản thành công");
//    }
//
//    @GetMapping("/list")
//    public Object getAllAccount(){
//        customerService.add(new Customer(0, "test", 6));
//        return customerService.getList();
//    }
}
