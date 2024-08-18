package com.yathin.TableBookingApplication.repositories;

import com.yathin.TableBookingApplication.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
