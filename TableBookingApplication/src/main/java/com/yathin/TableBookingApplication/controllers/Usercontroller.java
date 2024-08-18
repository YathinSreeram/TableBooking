package com.yathin.TableBookingApplication.controllers;


import com.yathin.TableBookingApplication.models.User;
import com.yathin.TableBookingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Usercontroller {

    @Autowired UserService user_service;

    @PostMapping ("/adduser")
    public User adduser(@RequestBody User u)
    {
        return user_service.saveUser(u);
    }

    @DeleteMapping ("/{user_id}/deleteuser")
    public void deleteuser(@PathVariable int user_id)
    {
        user_service.deleteUser(user_id);
    }

    @PutMapping ("/{user_id}/updateuser")
    public User updateuser(@PathVariable int user_id,@RequestBody User u)
    {
        return user_service.updateUser(user_id,u);
    }

}
