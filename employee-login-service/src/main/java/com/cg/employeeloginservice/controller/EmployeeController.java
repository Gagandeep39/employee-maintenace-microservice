package com.cg.employeeloginservice.controller;

import com.cg.employeeloginservice.model.ChangePassword;
import com.cg.employeeloginservice.model.User;
import com.cg.employeeloginservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Gagandeep
 * @date 06-05-2020
 * @time 02:52
 */

@CrossOrigin("*")
@RestController
@Api("Manage login related operations")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    @ApiOperation(value = "Logs in to system")
    public ResponseEntity<User> performLogin(@RequestBody User user){
        User loggedInUser = employeeService.performLogin(user);
        return new ResponseEntity<User>(loggedInUser, HttpStatus.OK);
    }

    @PostMapping("/login/add")
    @ApiOperation(value = "Adds new user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User addedUser = employeeService.addUser(user);
        return new ResponseEntity<>(addedUser, HttpStatus.OK);
    }

    @ApiOperation(value = "Changes password of user")
    @PostMapping("/login/change")
    public ResponseEntity<User> changePassword(@RequestBody ChangePassword changePassword) {
        User modifiedUser = employeeService.changePassword(changePassword);
        return new ResponseEntity<>(modifiedUser, HttpStatus.OK);
    }

    @PutMapping("/login/update")
    @ApiOperation(value = "Update details of user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User modifiedUser = employeeService.updateRole(user);
        return new ResponseEntity<>(modifiedUser, HttpStatus.OK);
    }

    @GetMapping("/login/{id}")
    @ApiOperation(value = "Fetches user by Id")
    public ResponseEntity<User> fetchUserById(@PathVariable Integer id) {
        User user = employeeService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
