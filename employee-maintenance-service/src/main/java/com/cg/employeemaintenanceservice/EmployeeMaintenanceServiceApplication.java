package com.cg.employeemaintenanceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrix
public class EmployeeMaintenanceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeMaintenanceServiceApplication.class, args);
    }

}
