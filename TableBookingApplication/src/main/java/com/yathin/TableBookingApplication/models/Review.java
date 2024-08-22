package com.yathin.TableBookingApplication.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratingID;

    private int rating;
    private String description;

    @ManyToOne
    @JsonIgnore

    private User user;

    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;


}
