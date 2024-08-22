package com.yathin.TableBookingApplication.DTO;
import com.yathin.TableBookingApplication.models.Restaurant;
import com.yathin.TableBookingApplication.models.Review;
import org.springframework.stereotype.Service;
import java.util.function.Function;

@Service
public class RestaurantMapper implements Function<Restaurant,RestaurantDTO> {

    @Override
    public RestaurantDTO apply(Restaurant restaurant) {
        return new RestaurantDTO(
                restaurant.getRestaurantName(),
                restaurant.getRestaurantLocation(),
                restaurant.getRestaurantDescription(),
                restaurant.getRestaurantCity(),
                restaurant.getReviews().stream().map(Review::getDescription).toList(),
                (long) restaurant.getReviews().stream().mapToInt(Review::getRating).average().orElse(0)
        );
    }
}