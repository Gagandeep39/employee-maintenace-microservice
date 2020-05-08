package com.cg.employeeleaveservice.service.implementation;

import com.cg.employeeleaveservice.model.LeaveHistory;
import com.cg.employeeleaveservice.repository.LeaveHistoryRepository;
import com.cg.employeeleaveservice.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author Gagandeep
 * @date 08-05-2020
 * @time 12:03
 */

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveHistoryRepository leaveHistoryRepository;

    @Override
    public LeaveHistory createLeave(LeaveHistory leaveHistory) {
        return leaveHistoryRepository.save(leaveHistory);
    }

    @Override
    public LeaveHistory updateLeave(LeaveHistory leaveHistory) {
        return leaveHistoryRepository.save(leaveHistory);
    }

    @Override
    public Page<LeaveHistory> fetchAllEmployeeLeave(Integer pageNo, Integer pageSize, String sortBy, Integer empId) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return leaveHistoryRepository.findByEmployeeDetails_EmpDetailsId(paging, empId);
    }

    @Override
    public Page<LeaveHistory> fetchAllSubEmployeeLeaves(Integer pageNo, Integer pageSize, String sortBy, Integer managerId) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return leaveHistoryRepository.findByEmployeeDetails_EmpDetailsId(paging, managerId);
    }
}
