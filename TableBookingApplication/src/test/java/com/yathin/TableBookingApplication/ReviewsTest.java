package com.yathin.TableBookingApplication;

import com.yathin.TableBookingApplication.models.Restaurant;
import com.yathin.TableBookingApplication.models.Review;
import com.yathin.TableBookingApplication.repositories.ReservationRepository;
import com.yathin.TableBookingApplication.repositories.RestaurantRepository;
import com.yathin.TableBookingApplication.repositories.ReviewRepository;
import com.yathin.TableBookingApplication.repositories.UserRepository;
import com.yathin.TableBookingApplication.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReviewsTest {

    @Mock
    ReviewRepository reviewRepository;

    @Mock
    ReservationRepository reservationRepository;

    @Mock
    UserRepository userRepository;

    @Mock
    RestaurantRepository restaurantRepository;

    @InjectMocks
    ReviewService reviewService;

    @Test
    public void addreviewsTest()
    {

        Review review = new Review();
        review.setDescription("Very nice food");
        review.setRating(4);

        when(reviewRepository.save(review)).thenReturn(review);
        Review result_review = reviewService.addReview(1,1,review);

        assertEquals(review,result_review);


    }

}
