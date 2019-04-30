package com.search.searchengine.service;

import com.google.gson.Gson;
import com.search.searchengine.model.EventWrapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class EventService {

    private static void getEvents() {

        final String url = "https://www.eventbriteapi.com/v3/events/search/?location.address=stockholm";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        Gson gson = new Gson();

        String jsonString = result.getBody();

        System.out.println(jsonString);

        EventWrapper eventWrapper = gson.fromJson(jsonString, EventWrapper.class);
    }


    public static void main(String[] args) {
        getEvents();
    }
}
