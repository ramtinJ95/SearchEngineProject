package com.search.searchengine.controller;

import com.google.gson.Gson;
import com.search.searchengine.model.DocumentES;
import com.search.searchengine.model.Event;
import com.search.searchengine.model.EventWrapper;
import com.search.searchengine.model.FrontendQuery;
import com.search.searchengine.repository.DocumentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    DocumentDao documentDao;

    public DocumentController(DocumentDao documentDao){
        this.documentDao = documentDao;
    }

    @GetMapping("/{documentId}")
    public Map<String, Object> getDocumentById(@PathVariable String documentId){
        return documentDao.getDocumentById(documentId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/search/{query}")
    public String queryIndex(@PathVariable String query) {
        return documentDao.getDocumentsForQuery(query);
    }

    // insert document
    @PostMapping
    public DocumentES insertDocument(@RequestBody DocumentES document) throws Exception {
        return documentDao.insertDocument(document);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/search/temp", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String createAndSearchBasedOnLocation(@RequestBody String frontendQueryString) {
        Gson gson = new Gson();
        FrontendQuery frontendQuery = gson.fromJson(frontendQueryString, FrontendQuery.class);
        ArrayList<Event> eventlist = getEventsBasedOnLocation(frontendQuery.getLatitude(), frontendQuery.getLongitude());
        insertEventsBasedOnLocationAsJson(eventlist, frontendQuery);
        return documentDao.getDocumentsForQuery(frontendQuery.getQuery());
    }

    // update document
    @PutMapping("/{id}")
    public Map<String, Object> updateDocumentById(@RequestBody DocumentES documentES, @PathVariable String id){
        return documentDao.updateDocumentById(id, documentES);

    }

    @DeleteMapping("/{id}")
    public void deleteDocumentById(@PathVariable String id){
        documentDao.deleteDocumentById(id);
    }

    private ArrayList<Event> getEventsBasedOnLocation(String latitude, String longitude) {
        final String url = "https://www.eventbriteapi.com/v3/events/search/?";
        String lat = "location.latitude="+latitude;
        String lon = "&location.longitude=" +longitude;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("VPVPICQJQCFVVQM5ELQF");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String test = url+lat+lon;
        System.out.println(test);
        ResponseEntity<String> result = restTemplate.exchange(url+lat+lon, HttpMethod.GET, entity, String.class);

        Gson gson = new Gson();
        String jsonString = result.getBody();

        EventWrapper eventWrapper = gson.fromJson(jsonString, EventWrapper.class);
        ArrayList<Event> eventList = (ArrayList<Event>) eventWrapper.getEvents();
        return eventList;
    }

    @SuppressWarnings("Duplicates")
    private void insertEventsBasedOnLocationAsJson(ArrayList<Event> eventlist, FrontendQuery frontendQuery) {
        for(int i = 0; i < eventlist.size(); i++) {
            Event event = eventlist.get(i);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            DocumentES documentES = new DocumentES();
            documentES.setEventName(event.getName());
            documentES.setStatus(event.getStatus());
            documentES.setSummary(event.getSummary());
            documentES.setText(event.getDescription());
            documentES.setLatitude(frontendQuery.getLatitude());
            documentES.setLongitude(frontendQuery.getLongitude());

            ResponseEntity<DocumentES> response = restTemplate.postForEntity("http://localhost:8080/documents",
                    documentES, DocumentES.class);
            if(response.getStatusCode().equals(HttpStatus.OK)){
                System.out.println(response.getBody().getId());
            }
        }
    }

}
