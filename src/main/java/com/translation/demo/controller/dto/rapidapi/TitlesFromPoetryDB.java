
package com.translation.demo.controller.dto.rapidapi;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "titles"
})
public class TitlesFromPoetryDB {

    @JsonProperty("titles")
    private List<String> titles = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("titles")
    public List<String> getTitles() {
        return titles;
    }

    @JsonProperty("titles")
    public void setTitles(List<String> titles) {
        this.titles = titles;
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
