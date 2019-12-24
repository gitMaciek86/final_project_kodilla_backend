package com.translation.demo.mapper;

import com.translation.demo.domain.db.Poem;
import com.translation.demo.domain.dto.PoemDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PoemMapperTestSuite {
    @InjectMocks
    PoemMapper poemMapper;

    @Test
    public void testMapToPoem() {
        //Given
        PoemDto poemDto = new PoemDto(1L, "title", "author", "lines", LocalDateTime.of(1,1,1,1,1,1,1));
        //When
        Poem result = poemMapper.mapToPoem(poemDto);
        //Then
        Assert.assertEquals(1L, result.getId(),0);
        Assert.assertEquals("title", result.getTitle());
        Assert.assertEquals("author", result.getAuthor());
        Assert.assertEquals("lines", result.getLines());
        Assert.assertEquals(LocalDateTime.of(1,1,1,1,1,1,1), result.getDateBought());
    }

    @Test
    public void testMapToPoemDto() {
        //Given
        Poem poem = new Poem(1L, "title", "author", "lines", LocalDateTime.of(1,1,1,1,1,1,1));
        //When
        PoemDto result = poemMapper.mapToPoemDto(poem);
        Assert.assertEquals(1L, result.getId(),0);
        Assert.assertEquals("title", result.getTitle());
        Assert.assertEquals("author", result.getAuthor());
        Assert.assertEquals("lines", result.getLines());
        Assert.assertEquals(LocalDateTime.of(1,1,1,1,1,1,1), result.getDateBought());
    }

    @Test
    public void testMapToPoemDtoList() {
        //Given
        List<Poem> poemList = new ArrayList<>();
        //Then
        poemList.add(new Poem(1L, "title", "author", "lines", LocalDateTime.of(1,1,1,1,1,1,1)));
        //When
        List<PoemDto> poemDtoList = poemMapper.mapToPoemDtoList(poemList);
        //Then
        Assert.assertEquals(1, poemDtoList.size());
        Assert.assertEquals("title", poemDtoList.get(0).getTitle());
        Assert.assertEquals("author", poemDtoList.get(0).getAuthor());
        Assert.assertEquals("lines", poemDtoList.get(0).getLines());
        Assert.assertEquals(LocalDateTime.of(1,1,1,1,1,1,1), poemDtoList.get(0).getDateBought());
    }
}
