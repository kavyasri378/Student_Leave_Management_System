package com.example.Project.Leap.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Project.Leap.Entity.Notification;
@Repository
public interface  NotificationRepository extends JpaRepository<Notification,Integer>{
    List<Notification> findByUserId(int userId);
}
