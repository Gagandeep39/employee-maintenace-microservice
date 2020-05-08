package com.cg.employeemaintenanceservice.service.implementation;

import com.cg.employeemaintenanceservice.model.User;
import com.cg.employeemaintenanceservice.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 02:13
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private User dummyUser;

    @Override
    @HystrixCommand(fallbackMethod = "fallbackAddUser")
    public User addUser(User user) {
        log.info("---------Add User---------");
        User addedUser = restTemplate.postForObject("http://localhost:9100/login/add", user, User.class);
        return addedUser;
    }

    /**
     * Fallback Method
     * NOTE: Throwing excetion from fallback will cause it to fail
     * @param user To be stored saved in user database
     * @return User Object with a generated ID
     */
    public User fallbackAddUser(User user) {
        return dummyUser;
    }

}
