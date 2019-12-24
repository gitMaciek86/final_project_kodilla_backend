package com.translation.demo.controller;

import com.translation.demo.controller.dto.rapidapi.TitlesFromPoetryDB;
import com.translation.demo.domain.db.Poem;
import com.translation.demo.domain.db.User;
import com.translation.demo.domain.dto.FullPoemDto;
import com.translation.demo.domain.dto.PoemDto;
import com.translation.demo.exceptions.PoemNotFoundException;
import com.translation.demo.mapper.PoemMapper;
import com.translation.demo.integration.poetryapi.PoemClient;
import com.translation.demo.service.PoemService;
import com.translation.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/poem")
@Log4j2
@AllArgsConstructor
public class PoemController {

    private PoemClient poemClient;
    private PoemService service;
    private PoemMapper poemMapper;
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "getPoems")
    public List<PoemDto> getPoems() {
        return poemMapper.mapToPoemDtoList(service.getAllPoems());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getPoem")
    public PoemDto getPoem(@RequestParam Long id) throws PoemNotFoundException {
        return poemMapper.mapToPoemDto(service.getPoem(id).orElseThrow(PoemNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deletePoem/{poemId}")
    public void deletePoem(@PathVariable Long poemId){
        service.deletePoem(poemId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updatePoem")
    public PoemDto updatePoem(PoemDto poemDto) {
        return poemMapper.mapToPoemDto(service.savePoem(poemMapper.mapToPoem(poemDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/alltitlesforuser/{id}")
    public List<PoemDto> getAllPoemsFromStore(@PathVariable String id) {
        return poemMapper.mapToPoemDtoList(poemClient.getPoemsForUser(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/alltitles")
    public TitlesFromPoetryDB getAllPoemsFromStore() {
        TitlesFromPoetryDB allPoemsTitles = poemClient.getAllPoemsTitles();
        List<String> newList = allPoemsTitles.getTitles().subList(0, 20);
        allPoemsTitles.setTitles(newList);
        return allPoemsTitles;
    }

    @RequestMapping(method = RequestMethod.POST, value = "buyPoem/{userId}", consumes = APPLICATION_JSON_VALUE)
    public void buyPoem(@RequestBody PoemDto poemDto, @PathVariable String userId){

        FullPoemDto poemByTitle = poemClient.getPoemByTitle(poemDto.getTitle());

        StringBuilder stringBuilder = new StringBuilder();
        poemByTitle.getLines().forEach(stringBuilder::append);
        String text = stringBuilder.toString();

        Poem poem = poemMapper.mapToPoem(poemDto);
        poem.setDateBought(LocalDateTime.now());
        poem.setAuthor(poemByTitle.getAuthor());
        poem.setLines(text);

        Optional<User> user1 = userService.getUser(Long.parseLong(userId));
        if (user1.isPresent()) {
            poem.setUser(user1.get());
            service.savePoem(poem);
        }
        else{
            throw new RuntimeException("User not found in database fo ID:"+userId);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/translatePoem")
    public String translatePoem(@RequestParam(value="q") String poemTitle) {
        return poemClient.translatePoem(poemTitle);
    }
}
