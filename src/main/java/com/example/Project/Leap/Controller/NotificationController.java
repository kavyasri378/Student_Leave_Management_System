package com.example.Project.Leap.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Leap.Entity.Notification;
import com.example.Project.Leap.Service.NotificationService;

@RestController
public class NotificationController {
    
    @Autowired
    private NotificationService notifi;

    @PostMapping("/LMS/Send")
    public Notification send(@RequestParam("user_id") int userId, @RequestParam String message){
        return notifi.sendNotification(userId,message); 
    }

    @GetMapping("/LMS/user/{id}")
    public List<Notification> getUserNotifications(@PathVariable int id)
    {
        return notifi.getUserNotifications(id);
    }

}
