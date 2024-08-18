package com.yathin.TableBookingApplication.controllers;

import com.yathin.TableBookingApplication.models.Reservation;
import com.yathin.TableBookingApplication.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Reservationcontroller {

    @Autowired
    ReservationService reservation_service;

    @PostMapping("/restaurant/{res_id}/{table_id}/{user_id}/book")
    public Reservation reserveTable(@PathVariable int res_id, @PathVariable int table_id, @PathVariable int user_id , @RequestBody Reservation res)
    {
        return reservation_service.reserve(res_id,table_id,user_id,res);
    }

    @GetMapping("/restaurant/{res_id}/getReservations")
    public List<Reservation> reservationsInRestaurant(@PathVariable int res_id)
    {
        return reservation_service.getReservations(res_id);
    }

    @DeleteMapping("/{reserve_id}/deleteReservation")
    public void deleteReservation(@PathVariable int reserve_id)
    {

        reservation_service.deletereservations(reserve_id);
    }

}
