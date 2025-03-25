package com.lms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "leave_balance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaveBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int balanceId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Foreign Key referencing User

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private LeaveType leaveType; // Foreign Key referencing LeaveType

    @Column(nullable = false)
    private int balance; // Number of remaining leaves
}
