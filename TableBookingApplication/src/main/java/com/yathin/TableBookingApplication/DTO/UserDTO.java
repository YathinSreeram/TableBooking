package com.yathin.TableBookingApplication.DTO;

import com.yathin.TableBookingApplication.models.Reservation;
import com.yathin.TableBookingApplication.models.Review;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.List;

public record UserDTO(

        int id,
        String username,
        String email,
        String ph_no,
        String address

) {
}
