package com.search.searchengine.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.search.searchengine.model.DocumentES;
import com.search.searchengine.model.Event;
import com.search.searchengine.model.EventWrapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

public class EventService {

    static final String url = "https://www.eventbriteapi.com/v3/events/search/?location.address=stockholm";
    private static ArrayList<Event> getEvents(){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("Put your API key here ");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        Gson gson = new Gson();

        String jsonString = result.getBody();

        EventWrapper eventWrapper = gson.fromJson(jsonString, EventWrapper.class);
        ArrayList<Event> eventList = (ArrayList<Event>) eventWrapper.getEvents();

        return eventList;
    }

    private static void insertEventsAsJsonDocuments(ArrayList<Event> eventList){
        for(int i = 0; i < eventList.size(); i++){
            Event event = eventList.get(i);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            DocumentES documentES = new DocumentES();
            documentES.setEventName(event.getName());
            documentES.setStatus(event.getStatus());
            documentES.setSummary(event.getSummary());
            documentES.setText(event.getDescription());

            ResponseEntity<DocumentES> response = restTemplate.postForEntity("http://localhost:8080/documents", documentES, DocumentES.class);
            if(response.getStatusCode().equals(HttpStatus.OK)){
                System.out.println(response.getBody().getId());
            }
        }

    }
    public static void main(String[] args) {
       ArrayList<Event> eventList =  getEvents();
       System.out.println(eventList.size());
       insertEventsAsJsonDocuments(eventList);

    }
}
