package com.example.parkingboytddpractice.repositories;

import com.example.parkingboytddpractice.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager manager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void should_return_user_when_save_given_a_user() {
        User user = new User("newuser");

        User returnUser = userRepository.save(user);

        assertThat(returnUser.getId(), is(1L));
    }
}
