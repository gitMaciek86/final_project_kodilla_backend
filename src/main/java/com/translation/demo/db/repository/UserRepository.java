package com.translation.demo.db.repository;

import com.translation.demo.domain.db.Poem;
import com.translation.demo.domain.db.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByLoginAndPassword(String login, String password);
}
