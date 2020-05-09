package com.cg.employeeleaveservice.controller;

import com.cg.employeeleaveservice.model.LeaveHistory;
import com.cg.employeeleaveservice.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author Gagandeep
 * @date 08-05-2020
 * @time 12:12
 */

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/employee/{empId}")
    public ResponseEntity<Page<LeaveHistory>> fetchEmployeeLeave(
            @PathVariable Integer empId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "leaveId") String sortBy){
        Page<LeaveHistory> leaveHistories = leaveService.fetchAllEmployeeLeave(pageNo, pageSize, sortBy, empId);
        return new ResponseEntity<>(leaveHistories, HttpStatus.OK);
    }

    @GetMapping("/manager/{managerId}")
    public ResponseEntity<Page<LeaveHistory>> fetchManagerLeaves(
            @PathVariable Integer managerId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "leaveId") String sortBy){
        Page<LeaveHistory> leaveHistories = leaveService.fetchAllSubEmployeeLeaves(pageNo, pageSize, sortBy, managerId);
        return new ResponseEntity<>(leaveHistories, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<LeaveHistory> addLeave(@RequestBody LeaveHistory leaveHistory){
        LeaveHistory updatedLeaveHistory = leaveService.createLeave(leaveHistory);
        return new ResponseEntity<>(updatedLeaveHistory, HttpStatus.ACCEPTED);
    }

    @PutMapping("/")
    public ResponseEntity<LeaveHistory> updateLeave(@RequestBody LeaveHistory leaveHistory){
        LeaveHistory updatedLeaveHistory = leaveService.updateLeave(leaveHistory);
        return new ResponseEntity<>(updatedLeaveHistory, HttpStatus.ACCEPTED);
    }

    @GetMapping("/balance/{empId}")
    public ResponseEntity<HashMap<String, Integer>> fetchBalance(@PathVariable Integer empId){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("balance", leaveService.fetchLeaveBalance(empId));
        return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
    }

}
