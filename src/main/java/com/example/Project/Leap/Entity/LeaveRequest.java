package com.example.Project.Leap.Entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
public class LeaveRequest {
    private int id;
    private int user_id;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private String status="Pending"; 
}
