package com.example.demo.services;

import com.example.demo.models.UserModel;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void saveUser(UserModel userDate){
        System.out.println("**********************************");
        System.out.println(userDate.getPhone());
        System.out.println(userDate.getId());
        System.out.println(userDate.getEmail());
        System.out.println(userDate.getSalary());
        System.out.println(userDate.getAge());
        System.out.println(userDate.getName());
        userRepo.save(userDate);
    }

    public List<UserModel> getUser(){
        return userRepo.findAll();
    }

}
