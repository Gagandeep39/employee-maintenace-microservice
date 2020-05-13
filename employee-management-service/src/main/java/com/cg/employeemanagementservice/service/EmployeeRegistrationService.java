package com.cg.employeemanagementservice.service;

import com.cg.employeemanagementservice.model.EmployeeDetails;
import com.cg.employeemanagementservice.model.User;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 01:37
 */
public interface EmployeeRegistrationService {

    EmployeeDetails addEmployeeDetails(User user);

	EmployeeDetails updateEmployeeDetails(EmployeeDetails user);

}
