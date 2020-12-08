package com.rmaj91;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ReceiverMain {

    public static void main(String[] args) {
        SpringApplication.run(ReceiverMain.class, args);
    }

}
