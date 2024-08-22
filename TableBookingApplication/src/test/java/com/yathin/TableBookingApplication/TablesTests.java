package com.yathin.TableBookingApplication;

import com.yathin.TableBookingApplication.models.Restaurant;
import com.yathin.TableBookingApplication.models.Tables;
import com.yathin.TableBookingApplication.repositories.RestaurantRepository;
import com.yathin.TableBookingApplication.repositories.TableRepository;
import com.yathin.TableBookingApplication.service.TableService;
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
public class TablesTests {

    @Mock
    TableRepository tableRepository;

    @Mock
    RestaurantRepository restaurantRepository;

    @InjectMocks
    TableService tableService;



    @Test
    public void addTableToRestaurant()
    {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantID(1);
        restaurant.setRestaurantName("Restaurant A");
        restaurant.setRestaurantLocation("Location A");
        restaurant.setRestaurantDescription("Description A");
        restaurant.setRestaurantTotalTableCount(10);
        restaurant.setRestaurantCity("City A");

        Tables tables = new Tables();
        tables.setTableID(1);
        tables.setTableNumber(1);
        tables.setTotalSeats(4);
        tables.setRestaurant(restaurant);

        List<Tables> tables_list = new ArrayList<>();
        tables_list.add(tables);
        restaurant.setTables(tables_list);

        when(tableRepository.save(tables)).thenReturn(tables);
        when(restaurantRepository.findById(1)).thenReturn(Optional.of(restaurant));
        Tables t = tableService.addTableToRestaurant(tables,1);

        assertEquals(true, tables_list.contains(t));

    }


    @Test
    public void deleteTableFromrestaurantTest()
    {
        tableService.deleteTableFromrestaurant(1,1);
        verify(tableRepository, times(1)).deleteById(1);
    }

}
