package com.cg.employeeleaveservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeLeaveServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeLeaveServiceApplication.class, args);
    }

}
