package com.example.parkingboytddpractice.services;

import com.example.parkingboytddpractice.entities.User;
import com.example.parkingboytddpractice.repositories.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @Test
    public void should_not_null_when_createUser() {
        UserService userService = new UserService(userRepository);
        User haha = mock(User.class);
//        verify(userRepository).save(any(User.class));
        when(userRepository.save(any(User.class))).thenReturn(new User());

        String password = userService.createUser(haha);
//        System.out.println(password);
        Assertions.assertNotNull(password);
    }
}
