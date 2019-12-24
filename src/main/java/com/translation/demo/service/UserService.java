package com.translation.demo.service;

import com.translation.demo.db.repository.PoemRepository;
import com.translation.demo.db.repository.UserRepository;
import com.translation.demo.domain.db.Poem;
import com.translation.demo.domain.db.User;
import com.translation.demo.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public Optional<User> login(UserDto userDto){
        return userRepository.findByLoginAndPassword(userDto.getLogin(), userDto.getPassword());
    }

    public Optional<User> getUser(final Long id){
        return userRepository.findById(id);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

}
