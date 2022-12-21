package com.example.ttstringboot.controller;

import com.example.ttstringboot.infras.model.Customer;
import com.example.ttstringboot.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping( value = "/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable long id){
        log.info("GET "+id);
        return customerService.get(id);
    }

    @RequestMapping(value="/customer/list", method = RequestMethod.GET)
    public List<Customer> getList(){
        log.info("GET All Customer");
        return customerService.getList();
    }

    @RequestMapping(value="/customer/{id}", method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable long id){
        log.info("DELETEING "+ id);
        return customerService.remove(id);
    }

    @RequestMapping(value="/customer", method = RequestMethod.POST)
    public String addCustomer(@RequestBody Customer customer){
        log.info("CREATING Customer");
        return customerService.add(customer);
    }

    @RequestMapping(value="/customer", method = RequestMethod.PUT)
    public String editCustomer(@RequestBody Customer customer){
        log.info("EDITING "+customer.getId());
        return customerService.replace(customer);
    }
}
