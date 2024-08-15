package com.yathin.TableBookingApplication.controllers;


import com.yathin.TableBookingApplication.models.User;
import com.yathin.TableBookingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usercontroller {

    @Autowired UserService user_service;


    @PostMapping ("/adduser")
    public User adduser(@RequestBody User u)
    {
        System.out.println("CONTROLLERRRRRRr");
        System.out.println(u);
        return user_service.saveUser(u);
    }
}
