package com.translation.demo.integration.poetryapi;

import com.translation.demo.controller.dto.rapidapi.TitlesFromPoetryDB;
import com.translation.demo.domain.db.Poem;
import com.translation.demo.domain.dto.FullPoemDto;
import com.translation.demo.service.PoemService;
import com.translation.demo.utils.encoder.Encoder;
import com.translation.demo.utils.rest.RestClient;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class PoemClient {

    private RestClient restClient;
    private PoemService poemService;

    public FullPoemDto getPoemByTitle(String title) {
        String encodedTitle = Encoder.encode(title);
        return Arrays.asList(restClient.buyPoetryBook(restClient.getRapidBasePath() + "title/" + encodedTitle)).get(0);
    }

    public List<Poem> getPoemsForUser(String id) {
        return poemService.getAllPoemsForUser(id);
    }

    public TitlesFromPoetryDB getAllPoemsTitles() {
        return restClient.makeRequestForPoetryTitles(restClient.getRapidBasePath() + "titles");
    }

    public String translatePoem(String poemTitle) {
        String encodedTitle = Encoder.encode(poemTitle).replace("\"","");
        return restClient.makeRequestGoogle(encodedTitle, "pl").getData().getTranslations().get(0).getTranslatedText();
    }
}
