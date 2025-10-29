package com.example.Project.Leap.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Leap.Entity.User;
import com.example.Project.Leap.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;

    //register the new user(save the details in db)
    public User register(User user){
        return userRepo.save(user);
    }

    //login function
    public User login(String email,String password){
        User user= userRepo.findByEmailAndPassword(email, password);
        return user;
    }

    //to get all user details from db
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
}
