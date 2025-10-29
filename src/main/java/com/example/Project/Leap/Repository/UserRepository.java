package com.example.Project.Leap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Project.Leap.Entity.User;

@Repository
public interface  UserRepository extends JpaRepository<User, Integer>{
    User findByEmailAndPassword(String email,String password);
}
