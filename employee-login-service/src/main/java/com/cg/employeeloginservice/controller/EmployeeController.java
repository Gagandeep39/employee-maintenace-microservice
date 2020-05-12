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

@CrossOrigin("*")
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

    @PutMapping("/login/change")
    public ResponseEntity<User> changePassword(@RequestBody User user) {
        User modifiedUser = employeeService.changePassword(user);
        return new ResponseEntity<>(modifiedUser, HttpStatus.OK);
    }

    @PutMapping("/login/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User modifiedUser = employeeService.updateRole(user);
        return new ResponseEntity<>(modifiedUser, HttpStatus.OK);
    }

    @GetMapping("/login/{id}")
    public ResponseEntity<User> fetchUserById(@PathVariable Integer id) {
        User user = employeeService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
