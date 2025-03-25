package com.lms.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "leave_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Foreign Key referencing User

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private LeaveType leaveType; // Foreign Key referencing LeaveType

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LeaveStatus status = LeaveStatus.PENDING; // Default: PENDING

    @Column(nullable = false)
    private Date appliedDate = new Date(); // Defaults to current date

    @ManyToOne
    @JoinColumn(name = "reviewed_by")
    private User reviewedBy; // Admin who reviewed the request

    private Date reviewedDate;
}

// Enum for Leave Status
enum LeaveStatus {
    PENDING, APPROVED, REJECTED
}
