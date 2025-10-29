package com.example.Project.Leap.Entity;

import java.time.LocalDateTime;

import org.springframework.aot.generate.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int user_id;
    private String message;
    private LocalDateTime sentTime;
}
