package com.translation.demo.db.repository;

import com.translation.demo.domain.db.Poem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PoemRepository extends CrudRepository<Poem, Long> {

    @Override
    List<Poem> findAll();

    @Override
    Poem save(Poem poem);

    void deleteById(Long id);

    @Override
    Optional<Poem> findById(Long id);

    List<Poem> findAllByUserId(Long id);
}
