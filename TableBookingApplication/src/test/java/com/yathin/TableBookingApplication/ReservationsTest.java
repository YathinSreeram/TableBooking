package com.yathin.TableBookingApplication;
import com.yathin.TableBookingApplication.models.Reservation;
import com.yathin.TableBookingApplication.models.User;
import com.yathin.TableBookingApplication.repositories.ReservationRepository;
import com.yathin.TableBookingApplication.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservationsTest {

    @Mock
    ReservationRepository reservationRepository;

    @InjectMocks
    ReservationService reservationService;

    @Test
    public void reservationTest()
    {
        User usr = new User(1, "JohnDoe", "john@example.com","1234567890", "12324352", "123 Elm Street");

        Reservation reservation = new Reservation();
        reservation.setReservationID(101);
        reservation.setPartySize(4);
        reservation.setReservationDate(LocalDate.of(2024, 8, 25));
        reservation.setReservationTime(LocalTime.of(19, 30));

        when(reservationRepository.save(reservation)).thenReturn(reservation);
        Reservation reservation_of_user =  reservationService.reserve(1,1,1,reservation);

        assertEquals(reservation, reservation_of_user);
    }

    @Test
    public void deleteReservationTest()
    {
        reservationService.deleteReservations(1);
        verify(reservationRepository, times(1)).deleteById(1);
    }
}
