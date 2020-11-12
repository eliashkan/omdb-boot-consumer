package com.realdolmen.omdbbootconsumer.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.realdolmen.omdbbootconsumer.model.Movie;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OmdbApiCaller {

    private final RestTemplate restTemplate;

    public OmdbApiCaller(RestTemplateBuilder rtb) {
        this.restTemplate = rtb.build();
    }

    public Movie requestMovie() {
        String url = "https://www.omdbapi.com/?t=chicago&apikey=2ed231aa";
        String movieJson = restTemplate.getForObject(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        Movie movie = null;
        try {
            JsonNode jsonNode = objectMapper.readTree(movieJson);
            movie = new Movie();
            String resultTitle = jsonNode.get("Title").asText();
            movie.setTitle(resultTitle);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return movie;
    }
}
