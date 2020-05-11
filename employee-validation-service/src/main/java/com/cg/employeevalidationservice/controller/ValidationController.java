/* 
@author Pranav Karmarkar
*/
package com.cg.employeevalidationservice.controller;

import java.util.HashMap;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employeevalidationservice.model.Department;
import com.cg.employeevalidationservice.model.Grade;
import com.cg.employeevalidationservice.model.Manager;
import com.cg.employeevalidationservice.model.Role;
import com.cg.employeevalidationservice.service.ValidationService;

@CrossOrigin("*")
@RestController
@Slf4j
public class ValidationController {

	@Autowired
	private ValidationService validationService;
	
	@GetMapping("/grades")
	public List<Grade> fetchAllGrades(){
		List<Grade> grades = validationService.fetchAllGrades();
		return grades;
	}
	
	@GetMapping("/departments")
	public List<Department> fetchAllDepartments(){
		List<Department> departments = validationService.fetchAllDepartments();
		return departments;
	}
	
	@GetMapping("/managers")
	public List<Manager> fetchAllManagers(){
		List<Manager> managers = validationService.fetchAllManagers();
		return managers;
	}

	@GetMapping("/username")
	public ResponseEntity<HashMap<String, Boolean>> checkUsernameExist(@RequestParam String username){
		HashMap<String, Boolean> map = new HashMap<>();
		log.info("----------------" + username);
		map.put("exists", validationService.usernameExists(username));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping("/roles")
	public ResponseEntity<List<Role>> getAllRoles(){
		List<Role> roles = validationService.fetchRoles();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
}
