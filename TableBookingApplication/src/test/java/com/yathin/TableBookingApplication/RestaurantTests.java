package com.yathin.TableBookingApplication;
import com.yathin.TableBookingApplication.models.Restaurant;
import com.yathin.TableBookingApplication.repositories.RestaurantRepository;
import com.yathin.TableBookingApplication.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RestaurantTests {

    @Mock
    RestaurantRepository restaurantRepository;

    @InjectMocks
    RestaurantService restaurantService;


    @Test
    public void addRestaurantTest()
    {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantID(1);
        restaurant.setRestaurantName("Restaurant A");
        restaurant.setRestaurantLocation("Location A");
        restaurant.setRestaurantDescription("Description A");
        restaurant.setRestaurantTotalTableCount(10);
        restaurant.setRestaurantCity("City A");
        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
        Restaurant r = restaurantService.saveRestaurant(restaurant);

        assertEquals(restaurant,r);
    }

    @Test
    public void getAllrestaurantTest()
    {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setRestaurantID(1);
        restaurant1.setRestaurantName("Restaurant A");
        restaurant1.setRestaurantLocation("Location A");
        restaurant1.setRestaurantDescription("Description A");
        restaurant1.setRestaurantTotalTableCount(10);
        restaurant1.setRestaurantCity("City A");

        // Create second Restaurant object
        Restaurant restaurant2 = new Restaurant();
        restaurant2.setRestaurantID(2);
        restaurant2.setRestaurantName("Restaurant B");
        restaurant2.setRestaurantLocation("Location B");
        restaurant2.setRestaurantDescription("Description B");
        restaurant2.setRestaurantTotalTableCount(15);
        restaurant2.setRestaurantCity("City B");

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurant1);
        restaurants.add(restaurant2);

        when(restaurantRepository.findAll()).thenReturn(restaurants);
        List<Restaurant> result = restaurantService.getAllRestaurants();

        assertEquals(2,result.size());
    }

    @Test
    public void getRestaurantByIDTest()
    {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setRestaurantID(1);
        restaurant1.setRestaurantName("Restaurant A");
        restaurant1.setRestaurantLocation("Location A");
        restaurant1.setRestaurantDescription("Description A");
        restaurant1.setRestaurantTotalTableCount(10);
        restaurant1.setRestaurantCity("City A");

        when(restaurantRepository.findById(1)).thenReturn(Optional.of(restaurant1));
        Restaurant result = restaurantService.getRestaurantById(1);

        assertEquals(1,result.getRestaurantID());
    }

    @Test
    public void deleteRestaurantByID()
    {
        restaurantService.deleteRestaurant(1);
        verify(restaurantRepository, times(1)).deleteById(1);
    }

}
