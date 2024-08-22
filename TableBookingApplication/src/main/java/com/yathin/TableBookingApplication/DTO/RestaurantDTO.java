package com.yathin.TableBookingApplication.DTO;

import java.util.List;

public record RestaurantDTO(

        String restaurantName,
        String restaurantLocation,
        String restaurantDescription,
        String restaurantCity,
        List<String> reviews,
        long avg_rating

) {
}
