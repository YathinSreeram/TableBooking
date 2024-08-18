package com.yathin.TableBookingApplication.service;

import com.yathin.TableBookingApplication.models.Reservation;
import com.yathin.TableBookingApplication.models.Restaurant;
import com.yathin.TableBookingApplication.models.Tables;
import com.yathin.TableBookingApplication.repositories.RestaurantRepository;
import com.yathin.TableBookingApplication.repositories.TableRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurant_repo;

    public Restaurant saveRestaurant(Restaurant r)
    {
        return restaurant_repo.save(r);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurant_repo.findAll();
    }

    public void deleteRestaurant(int res_id)
    {
        restaurant_repo.deleteById(res_id);
    }

}