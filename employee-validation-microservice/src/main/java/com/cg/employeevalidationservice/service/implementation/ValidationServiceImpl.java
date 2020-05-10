/* 
@author Pranav Karmarkar
*/
package com.cg.employeevalidationservice.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeevalidationservice.model.Department;
import com.cg.employeevalidationservice.model.Grade;
import com.cg.employeevalidationservice.model.Manager;
import com.cg.employeevalidationservice.repository.DepartmentRepository;
import com.cg.employeevalidationservice.repository.EmployeeRepository;
import com.cg.employeevalidationservice.repository.GradeRepository;
import com.cg.employeevalidationservice.service.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Grade> fetchAllGrades() {
		return gradeRepository.findAll();
	}

	@Override
	public List<Department> fetchAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public List<Manager> fetchAllManagers() {
		List<Object[]> list = employeeRepository.findAllManagers();
		List<Manager> managers = new ArrayList<>();
		for(Object[] obj : list)
		{
			Manager m = new Manager();
			m.setManagerId(Integer.parseInt(String.valueOf(obj[0])));
			m.setFirstName(String.valueOf(obj[1]));
			m.setLastName(String.valueOf(obj[2]));
			managers.add(m);
		}
		return managers;
	}

}
