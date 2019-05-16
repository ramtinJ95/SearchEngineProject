package com.search.searchengine.service;

import com.google.gson.Gson;
import com.search.searchengine.model.DocumentES;
import com.search.searchengine.model.Event;
import com.search.searchengine.model.EventWrapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

public class EventService {

//    static final String url = "https://www.eventbriteapi.com/v3/events/search/?location.address=sweden";

    private static EventWrapper getEventWrapper(String url) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("VPVPICQJQCFVVQM5ELQF");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        Gson gson = new Gson();

        String jsonString = result.getBody();

        EventWrapper eventWrapper = gson.fromJson(jsonString, EventWrapper.class);
        return eventWrapper;
    }

    @SuppressWarnings("Duplicates")
    private static void insertEventsAsJsonDocuments(EventWrapper eventWrapper) {
        ArrayList<Event> eventList = (ArrayList<Event>) eventWrapper.getEvents();
        for (int i = 0; i < eventList.size(); i++) {
            Event event = eventList.get(i);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            DocumentES documentES = new DocumentES();
            documentES.setEventName(event.getName());
            documentES.setStatus(event.getStatus());
            documentES.setSummary(event.getSummary());
            documentES.setText(event.getDescription());

            if (event.getCategory_id() != null) {
                documentES.setCategoryID(event.getCategory_id());
            }
            if (eventWrapper.getLatitude() != null) {
                documentES.setLatitude(eventWrapper.getLatitude());
            }
            if (eventWrapper.getLongitude() != null) {
                documentES.setLongitude(eventWrapper.getLongitude());
            }
            ResponseEntity<DocumentES> response = restTemplate.postForEntity("http://localhost:8080/documents", documentES, DocumentES.class);
            if (response.getStatusCode().equals(HttpStatus.OK)) {
                System.out.println(response.getBody().getId());
            }
        }

    }

    public static void main(String[] args) {
        String baseUrl = "https://www.eventbriteapi.com/v3/events/search/?location.address=sweden&page=1";
        EventWrapper eventWrapper = getEventWrapper(baseUrl);
        insertEventsAsJsonDocuments(eventWrapper);
        baseUrl = "https://www.eventbriteapi.com/v3/events/search/?location.address=sweden&page=%d";
        for (int i = 2; i < eventWrapper.getPageCount() + 1; i++) {
            String tempURL = String.format(baseUrl, i);
            System.out.println(baseUrl);
            EventWrapper temp = getEventWrapper(tempURL);
            insertEventsAsJsonDocuments(temp);
        }
    }
}
