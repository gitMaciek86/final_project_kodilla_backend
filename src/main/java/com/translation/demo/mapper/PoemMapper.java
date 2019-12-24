package com.translation.demo.mapper;

import com.translation.demo.domain.db.Poem;
import com.translation.demo.domain.dto.PoemDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PoemMapper {

    public Poem mapToPoem(final PoemDto poemDto) {
        return new Poem(
                poemDto.getId(),
                poemDto.getTitle(),
                poemDto.getAuthor(),
                poemDto.getLines(),
                poemDto.getDateBought());
    }

    public PoemDto mapToPoemDto(final Poem poem) {

        return PoemDto.builder()
                .id(poem.getId())
                .title(poem.getTitle())
                .lines(poem.getLines())
                .author(poem.getAuthor())
                .dateBought(poem.getDateBought())
                .build();
    }

    public List<PoemDto> mapToPoemDtoList(final List<Poem> poemList) {
        return poemList.stream()
                .map(t -> new PoemDto(t.getId(), t.getTitle(), t.getAuthor(), t.getLines(), t.getDateBought()))
                .collect(Collectors.toList());
    }
}
