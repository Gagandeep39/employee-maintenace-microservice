package com.cg.employeeloginservice.controller;

import com.cg.employeeloginservice.model.User;
import com.cg.employeeloginservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gagandeep
 * @date 06-05-2020
 * @time 02:52
 */

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public ResponseEntity<User> performLogin(@RequestBody User user){
        User loggedInUser = employeeService.performLogin(user);
        return new ResponseEntity<User>(loggedInUser, HttpStatus.OK);
    }

    @PostMapping("/login/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User addedUser = employeeService.addUser(user);
        return new ResponseEntity<>(addedUser, HttpStatus.OK);
    }

}
