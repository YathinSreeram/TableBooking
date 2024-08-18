package com.yathin.TableBookingApplication.service;

import com.yathin.TableBookingApplication.exception.NotFoundException;
import com.yathin.TableBookingApplication.models.Reservation;
import com.yathin.TableBookingApplication.models.Restaurant;
import com.yathin.TableBookingApplication.models.Tables;
import com.yathin.TableBookingApplication.models.User;
import com.yathin.TableBookingApplication.repositories.ReservationRepository;
import com.yathin.TableBookingApplication.repositories.RestaurantRepository;
import com.yathin.TableBookingApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservation_repo;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    UserRepository userRepository;

    public Reservation reserve(int res_id, int table_id, int user_id, Reservation r)
    {
        Restaurant res = new Restaurant();
        res.setRestaurantID(res_id);

        Tables table = new Tables();
        table.setTableID(table_id);

        User u = new User();
        u.setId(user_id);

        r.setRestaurant(res);
        r.setUser(u);
        r.setTable(table);

        return reservation_repo.save(r);

    }

    public List<Reservation> getReservations(int res_id)
    {
        Restaurant r = restaurantRepository.findById(res_id).orElse(null);
        return r.getReservations();
    }

    public void deletereservations(int reserve_id)
    {
        reservation_repo.deleteById(reserve_id);
    }



}
