/* 
@author Pranav Karmarkar
*/

package com.cg.employeevalidationservice.service;

import java.util.List;

import com.cg.employeevalidationservice.model.Department;
import com.cg.employeevalidationservice.model.Grade;
import com.cg.employeevalidationservice.model.Manager;

public interface ValidationService {

	List<Grade> fetchAllGrades();
	List<Department> fetchAllDepartments();
	List<Manager> fetchAllManagers();
}
