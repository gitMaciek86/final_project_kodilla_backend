package com.translation.demo.controller.dto.google;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "translatedText",
        "detectedSourceLanguage"
})
public class Translation {

    @JsonProperty("translatedText")
    private String translatedText;
    @JsonProperty("detectedSourceLanguage")
    private String detectedSourceLanguage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("translatedText")
    public String getTranslatedText() {
        return translatedText;
    }

    @JsonProperty("translatedText")
    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    @JsonProperty("detectedSourceLanguage")
    public String getDetectedSourceLanguage() {
        return detectedSourceLanguage;
    }

    @JsonProperty("detectedSourceLanguage")
    public void setDetectedSourceLanguage(String detectedSourceLanguage) {
        this.detectedSourceLanguage = detectedSourceLanguage;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
