package com.yathin.TableBookingApplication.repositories;

import com.yathin.TableBookingApplication.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
