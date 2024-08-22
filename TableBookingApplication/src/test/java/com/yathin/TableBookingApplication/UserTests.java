package com.yathin.TableBookingApplication;

import com.yathin.TableBookingApplication.DTO.UserDTO;
import com.yathin.TableBookingApplication.DTO.UserDTOMapper;
import com.yathin.TableBookingApplication.models.Reservation;
import com.yathin.TableBookingApplication.models.User;
import com.yathin.TableBookingApplication.repositories.UserRepository;
import com.yathin.TableBookingApplication.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserTests {
    @Mock
    UserRepository userRepository;

    @Mock
    UserDTOMapper userDTOMapper;

    @InjectMocks
    UserService userService;

    @Test
    public void getUsersTest()
    {
        List<User> lst = List.of(new User(1, "JohnDoe", "john@example.com", "12324352","1234567890", "123 Elm Street"),
                new User(2, "JaneDoe", "jane@example.com",  "13asf3423","0987654321", "456 Oak Street"));

		when(userRepository.findAll()).thenReturn(lst);
        List<UserDTO> list = userService.getAllUSers().getData();
        assertEquals(2,list.size());
    }

    @Test
    public void getUserByIDTest()
    {
        UserDTO userDTO = new UserDTO(1, "JohnDoe", "john@example.com", "1234567890", "123 Elm Street");
        User usr = new User(1, "JohnDoe", "john@example.com","1234567890", "12324352", "123 Elm Street");

        when(userRepository.findById(1)).thenReturn(Optional.of(usr));
        when(userDTOMapper.apply(usr)).thenReturn(userDTO);

        UserDTO u = userService.getUser(1).getData();
        assertEquals(1,u.id());
    }

    @Test
    public void getReservationsTest()
    {
        User usr = new User(1, "JohnDoe", "john@example.com","1234567890", "12324352", "123 Elm Street");

        when(userRepository.findById(1)).thenReturn(Optional.of(usr));
        List<Reservation> reservations = userService.getReservations(1).getData();

        assertEquals(null, reservations);
    }
}
