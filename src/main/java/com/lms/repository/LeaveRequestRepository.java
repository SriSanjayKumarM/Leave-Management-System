package com.lms.repository;

import com.lms.model.LeaveRequest;
import com.lms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
    // Fetch all leave requests for a specific user
    List<LeaveRequest> findByUser(User user);
}
