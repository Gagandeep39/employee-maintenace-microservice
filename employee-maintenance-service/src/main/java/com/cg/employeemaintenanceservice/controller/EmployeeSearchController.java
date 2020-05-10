package com.cg.employeemaintenanceservice.controller;

import com.cg.employeemaintenanceservice.model.EmployeeDetails;
import com.cg.employeemaintenanceservice.service.EmployeeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 03:11
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/employees")
public class EmployeeSearchController {

    @Autowired
    private EmployeeSearchService employeeSearchService;

    @GetMapping("/search")
    public ResponseEntity<Page<EmployeeDetails>> fetchAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "empDetailsId") String sortBy) {
        Page<EmployeeDetails> page = employeeSearchService.findAllEmployees(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(page, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/search/category")
    public ResponseEntity<Page<EmployeeDetails>> fetchByGenders(
            @RequestParam(defaultValue = "") String genders,
            @RequestParam(defaultValue = "") String maritalStatus,
            @RequestParam(defaultValue = "") String departments,
            @RequestParam(defaultValue = "") String grades,
            @RequestParam(defaultValue = "") Integer managerId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "empDetailsId") String sortBy) {
        Page<EmployeeDetails> page;
        if (!genders.equals(""))
            page = employeeSearchService.findByGenders(pageNo, pageSize, sortBy, genders);
        else if (!maritalStatus.equals(""))
            page = employeeSearchService.findByMaritalStatuses(pageNo, pageSize, sortBy, maritalStatus);
        else if (!departments.equals(""))
            page = employeeSearchService.findByDepartments(pageNo, pageSize, sortBy, departments);
        else if (!grades.equals(""))
            page = employeeSearchService.findByGrade(pageNo, pageSize, sortBy, grades);
        else
            page = employeeSearchService.findEmployeeByManagerId(pageNo, pageSize, sortBy, managerId);
        return new ResponseEntity<>(page, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/search/name")
    public ResponseEntity<Page<EmployeeDetails>> searchByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "empDetailsId") String sortBy){
        Page<EmployeeDetails> page = employeeSearchService.findByName(pageNo, pageSize, sortBy, name);
        return new ResponseEntity<>(page, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<EmployeeDetails> findById(@PathVariable Integer id){
        return new ResponseEntity<>(employeeSearchService.findById(id), HttpStatus.FOUND);
    }


}
