package com.cg.employeemaintenanceservice.service;

import com.cg.employeemaintenanceservice.model.EmployeeDetails;
import org.springframework.data.domain.Page;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 03:08
 */
public interface EmployeeSearchService {

    Page<EmployeeDetails> findEmployeeByManagerId(Integer pageNo, Integer pageSize, String sortBy, Integer managerId);
    Page<EmployeeDetails> findAllEmployees(Integer pageNo, Integer pageSize, String sortBy);
    Page<EmployeeDetails> findByGenders(Integer pageNo, Integer pageSize, String sortBy, String genders);
    Page<EmployeeDetails> findByMaritalStatuses(Integer pageNo, Integer pageSize, String sortBy, String maritalStatuses);
    Page<EmployeeDetails> findByDepartments(Integer pageNo, Integer pageSize, String sortBy, String departments);
    Page<EmployeeDetails> findByGrade(Integer pageNo, Integer pageSize, String sortBy, String grades);
    Page<EmployeeDetails> findByName(Integer pageNo, Integer pageSize, String sortBy, String name);
    EmployeeDetails findById(Integer id);
	Page<EmployeeDetails> findByFirstName(Integer pageNo, Integer pageSize, String sortBy, String firstName);
	Page<EmployeeDetails> findByLastName(Integer pageNo, Integer pageSize, String sortBy, String lastName);

}
