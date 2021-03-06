package com.rmaj91;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SenderMain {

    public static void main(String[] args) {
        SpringApplication.run(SenderMain.class, args);
    }

}
