package com.yathin.TableBookingApplication.controllers;
import com.yathin.TableBookingApplication.DTO.RestaurantDTO;
import com.yathin.TableBookingApplication.models.Restaurant;
import com.yathin.TableBookingApplication.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Restaurantcontroller {

    @Autowired
    RestaurantService restaurant_service;

    @PostMapping("/restaurants/addrestaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant r)
    {
        System.out.println(r);
        return restaurant_service.saveRestaurant(r);
    }
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants()
    {
        return restaurant_service.getAllRestaurants();
    }

    @GetMapping("/restaurant/{rest_is}")
    public Restaurant getRestaurantById(@PathVariable int rest_id)
    {
        return restaurant_service.getRestaurantById(rest_id);
    }

    @GetMapping ("/getRestaurantsNoTables")
    public List<RestaurantDTO> getRestaurantsNoTales()
    {
        return restaurant_service.getAllRestaurantsNoTables();
    }

    @DeleteMapping("/{res_id}/deleteRestaurant")
    public void deleteRestaurant(@PathVariable int res_id)
    {
        restaurant_service.deleteRestaurant(res_id);
    }
}