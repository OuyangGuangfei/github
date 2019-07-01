package com.qf.consumer_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
public class ConsumerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerWebApplication.class, args);
    }

}
