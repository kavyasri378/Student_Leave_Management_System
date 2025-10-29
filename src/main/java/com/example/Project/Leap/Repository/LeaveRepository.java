package com.example.Project.Leap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Project.Leap.Entity.LeaveRequest;

@Repository
public interface LeaveRepository  extends JpaRepository<LeaveRequest, Integer>{
    
}
