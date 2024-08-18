package com.yathin.TableBookingApplication.repositories;

import com.yathin.TableBookingApplication.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
