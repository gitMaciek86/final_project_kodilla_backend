package com.translation.demo.controller;

import com.google.gson.Gson;
import com.translation.demo.domain.db.Poem;
import com.translation.demo.domain.dto.PoemDto;
import com.translation.demo.integration.poetryapi.PoemClient;
import com.translation.demo.mapper.PoemMapper;
import com.translation.demo.service.PoemService;
import com.translation.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PoemController.class)
public class PoemControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PoemClient poemClient;
    @MockBean
    private PoemService service;
    @MockBean
    private PoemMapper poemMapper;
    @MockBean
    private UserService userService;

    @Test
    public void testGetPoem() throws Exception{
        //Given
        PoemDto poemDto = new PoemDto(1L, "title", "author", "lines", LocalDateTime.of(1,1,1,1,1,1,1));
        Poem poem = new Poem(1L, "title", "author", "lines", LocalDateTime.of(1,1,1,1,1,1,1));
        Optional<Poem> poem1 = Optional.of(poem);
        when(poemMapper.mapToPoemDto(any())).thenReturn(poemDto);
        when(service.getPoem(any())).thenReturn(poem1);
        //When & Then
        mockMvc.perform(get("/v1/poem/getPoem")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("title")))
                .andExpect(jsonPath("$.author", is("author")))
                .andExpect(jsonPath("$.lines", is("lines")));
    }

    @Test
    public void testGetPoems() throws Exception{
        //Given
        List<PoemDto> poemList = new ArrayList<>();
        PoemDto poemDto = new PoemDto(1L, "title", "author", "lines", LocalDateTime.of(1,1,1,1,1,1,1));
        poemList.add(poemDto);
        when(poemMapper.mapToPoemDtoList(any())).thenReturn(poemList);
        //When & Then
        mockMvc.perform(get("/v1/poem/getPoems").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("title")))
                .andExpect(jsonPath("$[0].author", is("author")))
                .andExpect(jsonPath("$[0].lines", is("lines")));
    }

    @Test
    public void testUpdatePoem() throws Exception{
        //Given
        PoemDto poemDto = new PoemDto(1L, "title", "author", "lines", LocalDateTime.of(1,1,1,1,1,1,1));
        when(poemMapper.mapToPoemDto(any())).thenReturn(poemDto);
        Gson gson = new Gson();
        String jsonString = gson.toJson(poemDto);
        mockMvc.perform(put("/v1/poem/updatePoem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("title")))
                .andExpect(jsonPath("$.author", is("author")))
                .andExpect(jsonPath("$.lines", is("lines")));
    }

    @Test
    public void testDeletePoem() throws Exception{
        //Given
        doNothing().when(service).deletePoem(anyLong());

        //When & Then
        mockMvc.perform(delete("/v1/poem/deletePoem/1")
                .contentType(MediaType.APPLICATION_JSON)
                .param("poemId", "1"))
                .andExpect(status().isOk());
        verify(service, times(1)).deletePoem(anyLong());
    }

//    @Test
//    public void buyPoem() throws Exception{
//        //Given
//        PoemDto poemDto = new PoemDto(1L, "title", "author", "lines", LocalDateTime.of(1,1,1,1,1,1,1));
//        when(service.savePoem(any())).thenReturn(null);
//        Gson gson = new Gson();
//        String jsonContent = gson.toJson(poemDto);
//        //When & Then
//        mockMvc.perform(post("/v1/poem/buyPoem/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .param("userId", "1")
//                .content(jsonContent))
//                .andExpect(status().isOk());
//        verify(service, times(1)).savePoem(any());
//    }
}

