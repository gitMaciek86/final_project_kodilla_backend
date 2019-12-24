package com.translation.demo.mapper;

import com.translation.demo.domain.db.User;
import com.translation.demo.domain.dto.UserDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTestSuite {
    @InjectMocks
    private UserMapper userMapper;

    @Test
    public void mapToUser() {
        //Given
        UserDto userDto = new UserDto(1L, "name", "surname", "login", "password", "mail");
        //When
        User result = userMapper.mapToUser(userDto);
        //Then
        Assert.assertEquals(1L, result.getId(),0);
        Assert.assertEquals("name", result.getUsername());
        Assert.assertEquals("surname", result.getSurname());
        Assert.assertEquals("login", result.getLogin());
        Assert.assertEquals("password", result.getPassword());
        Assert.assertEquals("mail", result.getMail());
    }

    @Test
    public void mapToUserDto() {
        User user = new User(1L, "name", "surname", "login", "password", "mail");
        //When
        UserDto result = userMapper.mapToUserDto(user);
        //Then
        Assert.assertEquals(1L, result.getId(),0);
        Assert.assertEquals("name", result.getUsername());
        Assert.assertEquals("surname", result.getSurname());
        Assert.assertEquals("login", result.getLogin());
        Assert.assertEquals("password", result.getPassword());
        Assert.assertEquals("mail", result.getMail());
    }
}