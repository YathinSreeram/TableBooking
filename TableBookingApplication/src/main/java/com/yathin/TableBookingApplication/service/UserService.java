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
}
