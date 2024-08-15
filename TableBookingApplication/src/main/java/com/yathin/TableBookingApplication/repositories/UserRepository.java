package com.yathin.TableBookingApplication.repositories;

import com.yathin.TableBookingApplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
