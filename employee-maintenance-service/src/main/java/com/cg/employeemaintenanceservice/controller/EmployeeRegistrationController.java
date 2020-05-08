	package com.cg.employeemaintenanceservice.controller;

import com.cg.employeemaintenanceservice.model.EmployeeDetails;
import com.cg.employeemaintenanceservice.model.User;
import com.cg.employeemaintenanceservice.service.EmployeeRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 01:41
 */

@RestController
public class EmployeeRegistrationController {

    @Autowired
    private EmployeeRegistrationService employeeRegistrationService;

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDetails> addEmployee(@RequestBody User user){
        EmployeeDetails employeeDetails = employeeRegistrationService.addEmployeeDetails(user);
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
    }

}
