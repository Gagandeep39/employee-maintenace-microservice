package com.cg.employeevalidationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeValidationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeValidationServiceApplication.class, args);
	}

}
