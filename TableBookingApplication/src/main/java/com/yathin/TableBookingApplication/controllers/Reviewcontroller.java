package com.yathin.TableBookingApplication.controllers;
import com.yathin.TableBookingApplication.Response.Response;
import com.yathin.TableBookingApplication.models.Review;
import com.yathin.TableBookingApplication.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Reviewcontroller {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/{user_id}/{res_id}/addreview")
    public Review addreview(@PathVariable int user_id, @PathVariable int res_id, @RequestBody Review review)
    {
       return reviewService.addReview(user_id,res_id,review);
    }

    @GetMapping("/{user_id}/getReviews")
    public Response<List<Review>> getReviews(@PathVariable int user_id)
    {
        return reviewService.getReviews(user_id);
    }

}