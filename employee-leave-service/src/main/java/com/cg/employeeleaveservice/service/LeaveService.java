package com.cg.employeeleaveservice.service;

import com.cg.employeeleaveservice.model.LeaveHistory;
import org.springframework.data.domain.Page;

/**
 * @author Gagandeep
 * @date 08-05-2020
 * @time 12:01
 */
public interface LeaveService {

    LeaveHistory createLeave(LeaveHistory leaveHistory, Integer empId);
    LeaveHistory updateLeave(LeaveHistory leaveHistory);
    Page<LeaveHistory> fetchAllEmployeeLeave(Integer pageNo, Integer pageSize, String sortBy, Integer empId);
    Page<LeaveHistory> fetchAllSubEmployeeLeaves(Integer pageNo, Integer pageSize, String sortBy, Integer managerId);
    Integer fetchLeaveBalance(Integer empId);

}
