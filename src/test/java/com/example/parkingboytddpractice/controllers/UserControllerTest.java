package com.example.parkingboytddpractice.controllers;

import com.example.parkingboytddpractice.entities.User;
import com.example.parkingboytddpractice.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void should_createUser_when_give_a_user() throws Exception {
        User user = new User();
        user.setUsername("newuser");
        when(userService.createUser(any(User.class))).thenReturn("123");

        ResultActions result = mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(user)));

        result.andExpect(status().isCreated()).andDo(print());
        String contentAsString = result.andReturn().getResponse().getContentAsString();
        Assertions.assertEquals("123",contentAsString);
    }

    @Test
    public void should_return_400_when_createUser_given_null() throws Exception {
        when(userService.createUser(any(User.class))).thenReturn("123");

        ResultActions result = mvc.perform(post("/users"));

        result.andExpect(status().is4xxClientError()).andDo(print());
    }



}
