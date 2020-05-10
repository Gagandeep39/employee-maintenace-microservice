/* 
@author Pranav Karmarkar
*/
package com.cg.employeevalidationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employeevalidationservice.model.Department;
import com.cg.employeevalidationservice.model.Grade;
import com.cg.employeevalidationservice.model.Manager;
import com.cg.employeevalidationservice.service.ValidationService;

@RestController
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
}
