package com.translation.demo.service;

import com.translation.demo.controller.dto.google.Translation;
import com.translation.demo.utils.rest.RestClient;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class TranslatorService {

    private RestClient restClient;

    public void testTranslate() {
        Translation translation = restClient.makeRequestGoogle("home", "pl").getData().getTranslations().get(0);
        log.info(translation.getTranslatedText());
    }
}
