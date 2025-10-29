package com.example.Project.Leap.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Leap.Entity.LeaveRequest;
import com.example.Project.Leap.Service.LeaveService;


@RestController
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @PostMapping("/LMS/leave/request")
    public LeaveRequest apply(@RequestBody LeaveRequest request){
        return leaveService.applyLeave(request);
    }

    @PutMapping("/LMS/leave/approve/{id}")
    public LeaveRequest approve(@PathVariable int id){
        return leaveService.approveLeave(id);
    }

    @PutMapping("/LMS/leave/reject/{id}")
    public LeaveRequest reject(@PathVariable int id){
        return leaveService.rejectLeave(id);
    }

    @GetMapping("/leaves")
    public List<LeaveRequest> getAllLeaveRequests() 
    {
        return leaveService.getAllLeaveRequests();
    }
    
    @GetMapping("/LMS/leave/user/{user_id}")
    public List<LeaveRequest> ggetLeaveRequestsByUserId(@PathVariable("user_id") int userId){
        return leaveService.getLeaveRequestsByUserId(userId);
    }

}


