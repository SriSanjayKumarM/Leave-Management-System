package com.lms.repository;

import com.lms.model.LeaveBalance;
import com.lms.model.User;
import com.lms.model.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Integer> {
    // Fetch leave balance for a specific user and leave type
    Optional<LeaveBalance> findByUserAndLeaveType(User user, LeaveType leaveType);
}
