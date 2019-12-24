package com.translation.demo.controller;


import com.translation.demo.domain.dto.UserDto;
import com.translation.demo.mapper.UserMapper;
import com.translation.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.client.ExpectedCount.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserMapper userMapper;

    @MockBean
    private UserService userService;

//    @Test
//    public void createUser() throws Exception {
//        //Given
//        UserDto userDto = new UserDto(1L, "name", "surname", "login", "password", "mail");
//        Mockito.when(userService.saveUser(any())).thenReturn(null);
//        //When & Then
//        mockMvc.perform(post("/v1/user/createUser")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//        verify(userService, times(1)).saveUser(any());}

}
