package com.yathin.TableBookingApplication.service;

import com.yathin.TableBookingApplication.models.User;
import com.yathin.TableBookingApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired UserRepository user_repo;

    public User saveUser(User u)
    {
        System.out.println("Service");
        return user_repo.save(u);
    }

}
