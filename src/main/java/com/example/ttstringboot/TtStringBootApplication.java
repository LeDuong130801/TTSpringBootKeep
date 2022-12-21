package com.example.ttstringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@Slf4j
@SpringBootApplication
public class TtStringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(TtStringBootApplication.class, args);
        log.info("Ứng dụng đang chạy");
    }

}
