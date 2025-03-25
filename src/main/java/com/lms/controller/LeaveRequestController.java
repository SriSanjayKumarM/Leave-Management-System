package com.lms.controller;

import com.lms.model.LeaveRequest;
import com.lms.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave-requests")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    // 1. Get all leave requests
    @GetMapping
    public ResponseEntity<List<LeaveRequest>> getAllLeaveRequests() {
        return ResponseEntity.ok(leaveRequestService.getAllLeaveRequests());
    }

    // 2. Get a specific leave request by ID
    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequest> getLeaveRequestById(@PathVariable int id) {
        return ResponseEntity.ok(leaveRequestService.getLeaveRequestById(id));
    }

    // 3. Create a new leave request
    @PostMapping
    public ResponseEntity<LeaveRequest> createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        return ResponseEntity.ok(leaveRequestService.createLeaveRequest(leaveRequest));
    }

    // 4. Approve or Reject a leave request
    @PutMapping("/{id}/status")
    public ResponseEntity<LeaveRequest> updateLeaveStatus(@PathVariable int id, @RequestParam String status) {
        return ResponseEntity.ok(leaveRequestService.updateLeaveStatus(id, status));
    }

    // 5. Delete a leave request
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLeaveRequest(@PathVariable int id) {
        leaveRequestService.deleteLeaveRequest(id);
        return ResponseEntity.ok("Leave request deleted successfully");
    }
}
