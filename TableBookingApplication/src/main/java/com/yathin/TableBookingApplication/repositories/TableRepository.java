package com.yathin.TableBookingApplication.repositories;

import com.yathin.TableBookingApplication.models.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Tables, Integer> {
}
