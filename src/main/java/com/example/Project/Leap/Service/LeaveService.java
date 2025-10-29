package com.example.Project.Leap.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Leap.Entity.LeaveRequest;
import com.example.Project.Leap.Entity.User;
import com.example.Project.Leap.Repository.LeaveRepository;
import com.example.Project.Leap.Repository.UserRepository;

@Service
public class LeaveService {
    
    @Autowired
    private LeaveRepository leaveRepo;

    @Autowired
    private UserRepository userRepo;

    public LeaveRequest applyLeave (LeaveRequest leaveRequest){
    User user = userRepo.findById(leaveRequest.getUserId()).orElse(null);
        
        if(user==null) return null;//if user not  found

        //to calculate total no of leave days
        long days= ChronoUnit.DAYS.between(leaveRequest.getStartDate(), leaveRequest.getEndDate()) + 1;

        //to check the leave bal and process the request
        if(user.getLeavebalance() >= days){
            user.setLeavebalance(user.getLeavebalance() - (int)days);
            userRepo.save(user);
            leaveRequest.setStatus("Pending");
            return leaveRepo.save(leaveRequest);
    }
    else{
        leaveRequest.setStatus("Rejected");
        return leaveRepo.save(leaveRequest);
    }
}

//approving the leave request by ID
public LeaveRequest approveLeave(int id){
    LeaveRequest req=leaveRepo.findById(id).orElse(null);
    if (req!=null){
        req.setStatus("Approved");
    }
    return leaveRepo.save(req);
}

//to reject the leave request by ID
public LeaveRequest rejectLeave(int id){
    LeaveRequest req=leaveRepo.findById(id).orElse(null);
    if(req!=null) req.setStatus("Rejected");
    return leaveRepo.save(req);
}

// to get display of all leave requests
public List<LeaveRequest> getAllLeaveRequests(){
    return leaveRepo.findAll();
}

//to get all leave request by user id
public List<LeaveRequest> getLeaveRequestsByUserId(int user_id){
    return leaveRepo.findByUserId(user_id);
}

}