package com.cg.employeemaintenanceservice.repository;

import com.cg.employeemaintenanceservice.enums.Gender;
import com.cg.employeemaintenanceservice.enums.Grade;
import com.cg.employeemaintenanceservice.enums.MaritalStatus;
import com.cg.employeemaintenanceservice.model.Department;
import com.cg.employeemaintenanceservice.model.EmployeeDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 01:35
 */

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {

    Page<EmployeeDetails> findByGenderIn(Collection<Gender> genders, Pageable pageable);

    Page<EmployeeDetails> findByDepartment_DepartmentIdIn(Collection<Integer> department, Pageable pageable);

    Page<EmployeeDetails> findByMaritalStatusIn(Collection<MaritalStatus> maritalStatuses, Pageable pageable);

    Page<EmployeeDetails> findByGradeIn(Collection<Grade> grade, Pageable pageable);

    Page<EmployeeDetails> findByManager_EmpDetailsId(Integer managerId, Pageable pageable);

    Page<EmployeeDetails> findEmployeeDetailsByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName, String lastName, Pageable pageable);

    Page<EmployeeDetails> findEmployeeDetailsByFirstNameContainingIgnoreCase(String firstName, Pageable pageable);

    Page<EmployeeDetails> findEmployeeDetailsByLastNameContainingIgnoreCase(String lastName, Pageable pageable);
}
