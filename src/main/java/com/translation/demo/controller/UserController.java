package com.translation.demo.controller;

import com.translation.demo.domain.db.User;
import com.translation.demo.domain.dto.UserDto;
import com.translation.demo.mapper.UserMapper;
import com.translation.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/user")
@Log4j2
@AllArgsConstructor
public class UserController {

    private UserMapper userMapper;
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "loginUser")
    public UserDto loginUser(@RequestBody UserDto userDto) {
        Optional<User> optionalUser = userService.login(userDto);
        if(optionalUser.isPresent()) {
            return userMapper.mapToUserDto(optionalUser.get());
        }
        else{
            return new UserDto();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public Long createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        return userService.saveUser(user).getId();
    }
}
