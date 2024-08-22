package com.yathin.TableBookingApplication.service;

import com.yathin.TableBookingApplication.Response.Response;
import com.yathin.TableBookingApplication.models.Reservation;
import com.yathin.TableBookingApplication.models.Restaurant;
import com.yathin.TableBookingApplication.models.Tables;
import com.yathin.TableBookingApplication.models.User;
import com.yathin.TableBookingApplication.repositories.ReservationRepository;
import com.yathin.TableBookingApplication.repositories.RestaurantRepository;
import com.yathin.TableBookingApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Response<List<Reservation>> getReservations(int res_id)
    {
        Restaurant r = restaurantRepository.findById(res_id).orElse(null);
        if(r == null)
            return Response.errorResponse("No restaurant found of the rest_id " + res_id );

        if(r.getReservations() == null)
            return Response.errorResponse("No reservations found of the rest_id " + res_id);

        return Response.successResponse(r.getReservations(), "The list of reservations of the restaurant with id " + res_id);
    }

    public void deleteReservations(int reserve_id)
    {
        reservation_repo.deleteById(reserve_id);
    }

}