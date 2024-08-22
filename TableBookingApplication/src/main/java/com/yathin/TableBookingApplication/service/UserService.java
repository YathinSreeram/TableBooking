package com.yathin.TableBookingApplication.service;

import com.yathin.TableBookingApplication.DTO.UserDTO;
import com.yathin.TableBookingApplication.Response.Response;
import com.yathin.TableBookingApplication.models.Reservation;
import com.yathin.TableBookingApplication.models.User;
import com.yathin.TableBookingApplication.repositories.ReservationRepository;
import com.yathin.TableBookingApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yathin.TableBookingApplication.DTO.UserDTOMapper;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDTOMapper userDTOMapper;

    @Autowired UserRepository user_repo;
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    Response<UserDTO> response;

    public User saveUser(User u)
    {
        System.out.println("Service");
        return user_repo.save(u);
    }

    public void deleteUser(int user_id)
    {
        user_repo.deleteById(user_id);
    }

    public User updateUser(int user_id,User u)
    {
        User existing_user = user_repo.findById(user_id).orElse(null);
        existing_user.setUsername(u.getUsername());
        existing_user.setEmail(u.getEmail());
        existing_user.setAddress(u.getAddress());
        existing_user.setPassword(u.getPassword());
        existing_user.setPh_no(u.getPh_no());
        return user_repo.save(existing_user);
    }

    public Response<UserDTO> getUser(int user_id){

        UserDTO userDTO = user_repo.findById(user_id).map(userDTOMapper).orElse(null);
        if(userDTO == null)
            return Response.errorResponse("No user found of user_id : " + user_id);
        return Response.successResponse(userDTO, "User found");

    }

    public Response<List<UserDTO>> getAllUSers()
    {
        List<UserDTO> userlist = user_repo.findAll().stream().map(userDTOMapper).toList();
        return  Response.successResponse(userlist, "All users!");
    }

    public Response<List<Reservation>> getReservations(int user_id)
    {
        User u = user_repo.findById(user_id).orElse(null);
        if(u == null)
        {
            return Response.errorResponse("No user found of the user_id : " + user_id);
        }
        if(u.getReservations() != null)
        {
            if(u.getReservations().isEmpty())
            {
                return Response.errorResponse("No reservations");
            }
        }

        return Response.successResponse(u.getReservations(), "Reservations of the user " + user_id);
    }
}