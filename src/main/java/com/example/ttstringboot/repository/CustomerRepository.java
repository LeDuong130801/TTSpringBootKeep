package com.example.ttstringboot.repository;

import com.example.ttstringboot.infras.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Long> {

}
