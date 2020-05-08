package com.cg.employeeleaveservice.repository;

import com.cg.employeeleaveservice.model.LeaveHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gagandeep
 * @date 08-05-2020
 * @time 09:13
 */

@Repository
@Transactional
public interface LeaveHistoryRepository extends JpaRepository<LeaveHistory, Integer> {

    Page<LeaveHistory> findByEmployeeDetails_EmpDetailsId(Pageable pageable, Integer empId);

    Page<LeaveHistory> findByEmployeeDetails_Manager_EmpDetailsId(Integer managerId, Pageable pageable);

    @Modifying
    @Query("update LeaveHistory l set l.leaveBalance=?2 where l.employeeDetails.empDetailsId=?1")
    void updateLeaveBalance(Integer empId, Integer updatedBalance);

}
