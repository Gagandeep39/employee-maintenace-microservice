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

}
