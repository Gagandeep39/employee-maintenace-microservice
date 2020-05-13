package com.cg.employeemanagementservice.config;

import com.cg.employeemanagementservice.model.User;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 02:15
 */

@Configuration
public class BeanConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public User getUser(){
        User user = new User();
        user.setEmpId(0);
        user.setUsername("Error Communicating with Login Service");
        return user;
    }

}
