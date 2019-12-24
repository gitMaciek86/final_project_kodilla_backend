package com.translation.demo.controller;

import com.translation.demo.service.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleTranslatorController {

    @Autowired
    private TranslatorService translatorService;

    public void translate(){
        translatorService.testTranslate();
    }
}
