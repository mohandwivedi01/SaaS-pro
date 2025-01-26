package com.example.demo.controllers;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class userController {
    @GetMapping
    public String healthCheck(){
        return "I'm running...";
    }
    @Autowired
    UserService userService;

    @GetMapping("/get-user")
    public List<UserModel> getUserData(){
        try {
            return userService.getUser();
        }catch (Exception e){
            System.out.println("**********error: "+e);
            throw new RuntimeException("Something went wrong while fetching data: "+e);
        }
    }
    @PostMapping("/add-user")
    public String saveUserData(@RequestBody UserModel userData){
        System.out.println("hello bhai m to chal raha hun");
        try {
            System.out.println("############User Data:  "+userData.getName());
            System.out.println(userData.getAge());
            System.out.println(userData.getPhone());
            System.out.println(userData.getSalary());
            System.out.println(userData.getEmail());
            userService.saveUser(userData);
            return "user data saved successfully";
        }catch (Exception e){
            System.out.println("****error: "+e);
            throw new RuntimeException(e);
        }
    }
}
