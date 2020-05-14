package com.cg.employeemanagementservice.repository;

import com.cg.employeemanagementservice.enums.Gender;
import com.cg.employeemanagementservice.enums.Grade;
import com.cg.employeemanagementservice.enums.MaritalStatus;
import com.cg.employeemanagementservice.entity.EmployeeDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 01:35
 */

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {

    Page<EmployeeDetails> findByGenderIn(Collection<Gender> genders, Pageable pageable);

    Page<EmployeeDetails> findByDepartment_DepartmentNameIn(Collection<String> department, Pageable pageable);

    Page<EmployeeDetails> findByMaritalStatusIn(Collection<MaritalStatus> maritalStatuses, Pageable pageable);

    Page<EmployeeDetails> findByGradeIn(Collection<Grade> grade, Pageable pageable);

    Page<EmployeeDetails> findByManager_EmpDetailsId(Integer managerId, Pageable pageable);

    Page<EmployeeDetails> findEmployeeDetailsByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName, String lastName, Pageable pageable);

    Page<EmployeeDetails> findEmployeeDetailsByFirstNameContainingIgnoreCase(String firstName, Pageable pageable);

    Page<EmployeeDetails> findEmployeeDetailsByLastNameContainingIgnoreCase(String lastName, Pageable pageable);
}
