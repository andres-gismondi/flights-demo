package com.api.demoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.api.demoproject"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
