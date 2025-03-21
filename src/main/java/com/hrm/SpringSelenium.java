package com.hrm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class SpringSelenium {

    public static void main(String[] args) {
        SpringApplication.run(SpringSelenium.class, args);
    }
}