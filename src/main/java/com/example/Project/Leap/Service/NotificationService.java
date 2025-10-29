package com.example.Project.Leap.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Leap.Entity.Notification;
import com.example.Project.Leap.Repository.NotificationRepository;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository repo;

    //to send notification user
    public Notification sendNotification(int user_id,String msg){
        Notification n=new Notification();
        n.setUser_id(user_id);
        n.setMessage(msg);
        n.setSentTime(LocalDateTime.now());
        return repo.save(n);
    }
    
    //to get all notifications of a user
    public List<Notification> getUserNotifications(int user_id){
        return repo.findByUser_id(user_id);
}

}
