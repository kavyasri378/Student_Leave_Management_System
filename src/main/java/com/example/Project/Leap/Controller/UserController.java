package com.example.Project.Leap.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Project.Leap.Entity.User;
import com.example.Project.Leap.Service.UserService;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/LMS/reg")
    public User register(@RequestBody User user) {
        User entity =userService.register(user);        
        return entity;
    }

    @PostMapping("/LMS/login")
    public String login(@RequestParam String email, @RequestParam String password){
        User user=userService.login(email,password);
        if(user!=null){
            return "Login Successful. Welcome "+user.getName()+"!";
        }
        else{
            return "Invalid email or password .Please try again later.";
        }
    }
    
    
}
