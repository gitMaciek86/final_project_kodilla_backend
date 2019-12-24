package com.translation.demo.mapper;

import com.translation.demo.domain.db.User;
import com.translation.demo.domain.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getSurname(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getMail());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getSurname(),
                user.getLogin(),
                user.getPassword(),
                user.getMail());
    }
}
