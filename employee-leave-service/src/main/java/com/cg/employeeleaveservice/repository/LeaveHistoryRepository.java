package com.cg.employeeleaveservice.repository;

import com.cg.employeeleaveservice.model.EmployeeDetails;
import com.cg.employeeleaveservice.model.LeaveHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gagandeep
 * @date 08-05-2020
 * @time 09:13
 */

@Repository
public interface LeaveHistoryRepository extends JpaRepository<LeaveHistory, Integer> {

    Page<LeaveHistory> findByEmployeeDetails_EmpDetailsId(Pageable pageable, Integer empId);

    // TODO - Broken
    Page<LeaveHistory> findLeaveHistoriesByEmployeeDetails_SubEmployees_(Integer employeeDetails_manager_empDetailsId, Pageable pageable);

}
