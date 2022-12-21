package com.example.ttstringboot.service;

import com.example.ttstringboot.infras.model.Customer;
import com.example.ttstringboot.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String add(Customer customer) {
        long id = 0;
        Random r = new Random();
        while (customerRepository.existsById(id) || id<=0){
            id = r.nextInt();
        }
        customer.setId(id);
        customerRepository.insert(customer);
        log.info("Added "+id);
        return "Add new successfully!";
    }

    public String replace(Customer customer){
//        long id = customer.getId();
//        for(Customer c : list){
//            if(c.getId() == id){
//                if(customer.getAge()>0) c.setAge(customer.getAge());
//                if(!customer.getName().equals("")) c.setName(customer.getName());
//                return "Replace "+id+" successfully!";
//            }
//        }
        if(customerRepository.existsById(customer.getId())){
            Optional<Customer> c = customerRepository.findById(customer.getId());
            c.get().setAge(customer.getAge());
            c.get().setName(customer.getName());
            customerRepository.save(c.get());
            log.info("Updated "+customer.getId());
            return "Update successfully!";
        }
        log.error("Not found "+customer.getId());
        return "Not found!";
    }

    public Customer get(long id){
//        for(Customer c: list){
//            if(c.getId() == id){
//                return c;
//            }
//        }
//        return null;
        return customerRepository.findById(id).get();
    }

    public String remove(long id){
//        for(Customer c: list){
//            if(c.getId() == id){
//                list.remove(c);
//                return "Delete "+id+" successfully!";
//            }
//        }
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            log.info("Deleted "+id);
            return "Deleted "+id;
        }
        log.error("Not found "+id);
        return "Not found!";
    }

    public List<Customer> getList() {
        return customerRepository.findAll();
    }
}