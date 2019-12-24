package com.translation.demo.service;

import com.translation.demo.domain.db.Poem;
import com.translation.demo.domain.db.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PoemServiceTest {

    @Autowired
    private PoemService poemService;

    @Test
    public void getPoem() {
        //Given
        Poem poem = new Poem(null, "title1", "author1", "lines", LocalDateTime.now());
        Poem poem2 = poemService.savePoem(poem);
        //When
        Optional<Poem> poem3 = poemService.getPoem(poem2.getId());
        //Then
        Assert.assertEquals("author1", poem3.orElse(null).getAuthor());
        Assert.assertEquals("title1", poem3.orElse(null).getTitle());
        Assert.assertEquals("lines", poem3.orElse(null).getLines());
    }

    @Test
    public void deletePoem() {
        //Given
        int size = poemService.getAllPoems().size();
        Poem poem = new Poem(null, "title1", "author1", "lines", LocalDateTime.now());
        Poem poem2 = poemService.savePoem(poem);
        //When
        poemService.deletePoem(poem2.getId());
        int size2 = poemService.getAllPoems().size();
        //Then
        Assert.assertEquals(size, size2);
    }

    @Test
    public void getAllPoemsForUser() {
        //Given
        Poem poem = new Poem(null, "title1", "author1", "lines", LocalDateTime.now());
        Poem poem2 = new Poem(null, "title1", "author1", "lines", LocalDateTime.now());
        Poem poem3 = new Poem(null, "title1", "author1", "lines", LocalDateTime.now());
        User user = new User(1L, "name", "surname", "login", "password", "mail");
        HashSet<Poem> poemSet = new HashSet<Poem>();
        poemSet.add(poem);
        poemSet.add(poem2);
        poemSet.add(poem3);
        user.setPoemsSet( poemSet);
        //When
        int result = user.getPoemsSet().size();
        //Then
        Assert.assertEquals(3, result);
    }
}
