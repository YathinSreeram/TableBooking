package com.yathin.TableBookingApplication.controllers;


import com.yathin.TableBookingApplication.DTO.UserDTO;
import com.yathin.TableBookingApplication.Response.Response;
import com.yathin.TableBookingApplication.models.Reservation;
import com.yathin.TableBookingApplication.models.User;
import com.yathin.TableBookingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Usercontroller {

    @Autowired UserService user_service;
    @Autowired Response response;


    @PostMapping ("/adduser")
    public User adduser(@RequestBody User u)
    {
        return user_service.saveUser(u);
    }

    @GetMapping("/{user_id}/getuser")
    public Response<UserDTO> getuser(@PathVariable int user_id){
        return user_service.getUser(user_id);
    }

    @GetMapping("/getusers")
    public Response<List<UserDTO>> getusers()
    {
        return user_service.getAllUSers();
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

    @GetMapping ("/{user_id}/getreservations")
    public Response<List<Reservation>> updateuser(@PathVariable int user_id)
    {
        return user_service.getReservations(user_id);
    }
}
