package com.lms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "leave_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;  // Primary Key

    @Column(unique = true, nullable = false)
    private String typeName; // ie; "Sick Leave", "Annual Leave"
}
