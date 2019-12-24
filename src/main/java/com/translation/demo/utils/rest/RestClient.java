package com.translation.demo.utils.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.translation.demo.controller.dto.google.GoogleTranslateDTO;
import com.translation.demo.controller.dto.rapidapi.TitlesFromPoetryDB;
import com.translation.demo.domain.dto.FullPoemDto;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
@Log4j2
@Getter
public class RestClient {

    @Value("${poem.google.basepath}")
    private String googleBasePath;
    @Value("${poem.google.apiKey}")
    private String googleApiKey;
    @Value("${poem.app.basepath}")
    private String rapidBasePath;
    @Value("${poem.api.endpoint.prod}")
    private String rapidApihost;
    @Value("${poem.app.key}")
    private String rapidApiKey;

    @PostConstruct
    public void configUniRest(){
        Unirest.setObjectMapper(new ObjectMapper() {
            com.fasterxml.jackson.databind.ObjectMapper mapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();
            public String writeValue(Object value) {
                try {
                    return mapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                throw new IllegalArgumentException();
            }

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return mapper.readValue(value, valueType);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                throw new IllegalArgumentException();
            }
        });
    }

    public GoogleTranslateDTO makeRequestGoogle(String text, String targetLanguage){
        try {
            HttpResponse<GoogleTranslateDTO> httpResponse = Unirest.get(googleBasePath+"target="+targetLanguage+"&key="+googleApiKey+"&q="+text)
                    .asObject(GoogleTranslateDTO.class);
            return httpResponse.getBody();
        } catch (UnirestException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public TitlesFromPoetryDB makeRequestForPoetryTitles(String fullUrl){
        try {
            HttpResponse<TitlesFromPoetryDB> httpResponse = Unirest.get(fullUrl)
                    .header("x-rapidapi-host", rapidApihost)
                    .header("x-rapidapi-key", rapidApiKey)
                    .asObject(TitlesFromPoetryDB.class);
            return httpResponse.getBody();
        } catch (UnirestException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public FullPoemDto[] buyPoetryBook(String fullUrl){
        try {
            HttpResponse<FullPoemDto[]> httpResponse = Unirest.get(fullUrl)
                    .header("x-rapidapi-host", rapidApihost)
                    .header("x-rapidapi-key", rapidApiKey)
                    .asObject(FullPoemDto[].class);
            return httpResponse.getBody();
        } catch (UnirestException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

}
