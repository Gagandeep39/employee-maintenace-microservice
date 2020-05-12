	package com.cg.employeemaintenanceservice.controller;

import com.cg.employeemaintenanceservice.model.EmployeeDetails;
import com.cg.employeemaintenanceservice.model.User;
import com.cg.employeemaintenanceservice.service.EmployeeRegistrationService;
import com.cg.employeemaintenanceservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 01:41
 */

@CrossOrigin("*")
@RestController
public class EmployeeRegistrationController {

    @Autowired
    private EmployeeRegistrationService employeeRegistrationService;

    @Autowired
    private UserService userService;

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDetails> addEmployee(@RequestBody User user){
        EmployeeDetails employeeDetails = employeeRegistrationService.addEmployeeDetails(user);
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
    }

    @PostMapping("/employees/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User addedUser = userService.addUser(user);
        return new ResponseEntity<>(addedUser, HttpStatus.OK);
    }

    @PutMapping("/employees")
    public ResponseEntity<EmployeeDetails> updateEmployeeDetails(@RequestBody EmployeeDetails details){
        EmployeeDetails employeeDetails = employeeRegistrationService.updateEmployeeDetails(details);
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
    }

}
