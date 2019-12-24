package com.translation.demo.service;

import com.translation.demo.domain.db.Poem;
import com.translation.demo.db.repository.PoemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class PoemService {

    private PoemRepository poemRepository;

    public List<Poem> getAllPoems() {
        return poemRepository.findAll();
    }

    public Optional<Poem> getPoem(final Long id){
        return poemRepository.findById(id);
    }

    public Poem savePoem(final Poem poem) {
        return poemRepository.save(poem);
    }

    public void deletePoem(final long poemId) {
        poemRepository.deleteById(poemId);
    }

    public List<Poem> getAllPoemsForUser(String id) {
        return poemRepository.findAllByUserId(Long.parseLong(id));
    }
}
