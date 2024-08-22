package com.yathin.TableBookingApplication.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private String ph_no;
    private String address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Reservation> reservations;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Review> reviews;

    public User(int id, String username, String email, String password, String ph_no, String address) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.ph_no = ph_no;
        this.address = address;

    }


}
