package com.yathin.TableBookingApplication.service;

import com.yathin.TableBookingApplication.Response.Response;
import com.yathin.TableBookingApplication.models.Restaurant;
import com.yathin.TableBookingApplication.models.Review;
import com.yathin.TableBookingApplication.models.User;
import com.yathin.TableBookingApplication.repositories.RestaurantRepository;
import com.yathin.TableBookingApplication.repositories.ReviewRepository;
import com.yathin.TableBookingApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    UserRepository userRepository;

    public Review addReview(int user_id, int res_id, Review review)
    {
        Restaurant res = restaurantRepository.findById(res_id).orElse(null);
        User u = userRepository.findById(user_id).orElse(null);

        review.setRestaurant(res);
        review.setUser(u);

        return reviewRepository.save(review);
    }

    public Response<List<Review>> getReviews(int user_id)
    {
        User u = userRepository.findById(user_id).orElse(null);
        if(u == null)
            return Response.errorResponse("No user found of the user_id :" +user_id);
        if(u.getReviews().isEmpty())
            return Response.errorResponse("No reviews of the user");

        return Response.successResponse(u.getReviews(), "The reviews of the user with user_id : " + user_id);
    }
}