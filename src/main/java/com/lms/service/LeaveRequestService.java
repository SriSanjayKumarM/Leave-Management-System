package com.lms.service;

import com.lms.model.LeaveRequest;
import com.lms.model.LeaveStatus;
import com.lms.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    // 1. Get all leave requests
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    // 2. Get leave request by ID
    public LeaveRequest getLeaveRequestById(int id) {
        return leaveRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));
    }

    // 3. Create a new leave request
    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    // 4. Approve or Reject a leave request
    public LeaveRequest updateLeaveStatus(int id, String status) {
        LeaveRequest leaveRequest = getLeaveRequestById(id);
        leaveRequest.setStatus(LeaveStatus.valueOf(status.toUpperCase())); // Convert input to Enum
        return leaveRequestRepository.save(leaveRequest);
    }

    // 5. Delete a leave request
    public void deleteLeaveRequest(int id) {
        leaveRequestRepository.deleteById(id);
    }
}
