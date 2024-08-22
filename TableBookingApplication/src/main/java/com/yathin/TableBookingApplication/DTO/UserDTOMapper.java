package com.yathin.TableBookingApplication.DTO;

import com.yathin.TableBookingApplication.models.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {

    @Override
    public UserDTO apply(User user) {
        return new UserDTO(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPh_no(),
                user.getAddress()
        );
    }
}
