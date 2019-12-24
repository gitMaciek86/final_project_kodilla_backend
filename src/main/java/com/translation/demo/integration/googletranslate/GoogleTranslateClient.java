package com.translation.demo.integration.googletranslate;

import com.translation.demo.service.TranslatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/translate")
@AllArgsConstructor
public class GoogleTranslateClient {

    private TranslatorService translatorService;

    @GetMapping(value = "/title")
    public String translate(){
        //String text, String language
        translatorService.testTranslate();
        return "";
    }
}
