package com.yathin.TableBookingApplication.service;

import com.yathin.TableBookingApplication.models.Restaurant;
import com.yathin.TableBookingApplication.models.Tables;
import com.yathin.TableBookingApplication.repositories.RestaurantRepository;
import com.yathin.TableBookingApplication.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TableService {

    @Autowired
    TableRepository table_repo;

    @Autowired
    RestaurantRepository restaurantRepository;

    public Tables getTableDetails(int id)
    {
        return table_repo.findById(id).orElse(new Tables());
    }

    public Tables addTableToRestaurant(Tables t,int resId)
    {
        Restaurant r = restaurantRepository.findById(resId).orElse(null);

        r.setRestaurantTotalTableCount(r.getRestaurantTotalTableCount()+1);

        t.setRestaurant(r);
        return  table_repo.save(t);
    }

    public void deleteTableFromrestaurant(int res_id, int table_id)
    {
        table_repo.deleteById(table_id);
    }
}