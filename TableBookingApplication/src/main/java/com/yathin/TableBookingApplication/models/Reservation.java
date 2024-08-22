package com.yathin.TableBookingApplication.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationID;

    @ManyToOne
    @JsonIgnore

    private User user;

    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;

    @ManyToOne
    @JsonIgnore
    private Tables table;

    private LocalDate reservationDate;

    private LocalTime reservationTime;

    private int partySize;



}
