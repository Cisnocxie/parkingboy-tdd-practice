package com.example.parkingboytddpractice.services;

import com.example.parkingboytddpractice.entities.User;
import com.example.parkingboytddpractice.repositories.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Test
    public void should_not_null_when_createUser() {
        UserService userService = new UserService(userRepository);
        User user = mock(User.class);
        when(userRepository.save(any(User.class))).thenReturn(null);

        String password = userService.createUser(user);

        Assertions.assertNotNull(password);
    }
}
