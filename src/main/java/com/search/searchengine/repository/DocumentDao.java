package com.search.searchengine.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.search.searchengine.model.DocumentES;
import com.search.searchengine.model.SearchEntry;
import com.search.searchengine.utility.Utilities;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Repository;

import java.util.*;

import static org.elasticsearch.index.query.QueryBuilders.*;

@Repository
public class DocumentDao {
    private final String INDEX = "documentdata";
    private final String TYPE = "events";
    private RestHighLevelClient restHighLevelClient;
    private ObjectMapper objectMapper;
    private Utilities utilities = new Utilities();

    public DocumentDao(ObjectMapper objectMapper, RestHighLevelClient restHighLevelClient) {
        this.objectMapper = objectMapper;
        this.restHighLevelClient = restHighLevelClient;

        CreateIndexRequest request = new CreateIndexRequest(INDEX);
        String didItWork = request.index();
        System.out.println(didItWork);
    }

    // insert
    public DocumentES insertDocument(DocumentES document) {
        document.setId(UUID.randomUUID().toString());
        Map dataMap = objectMapper.convertValue(document, Map.class);
        IndexRequest indexRequest = new IndexRequest(INDEX).id(document.getId()).source(dataMap);

        try {
            IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (ElasticsearchException e) {
            e.getDetailedMessage();
        } catch (java.io.IOException ex) {
            ex.getLocalizedMessage();
        }
        return document;
    }

    // search query by id for now
    public Map<String, Object> getDocumentById(String documentId) {
        GetRequest getRequest = new GetRequest(INDEX, documentId);
        GetResponse getResponse = null;
        try {
            getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        } catch (java.io.IOException e) {
            e.getLocalizedMessage();
        }
        Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
        return sourceAsMap;
    }

    // update document by id
    public Map<String, Object> updateDocumentById(String documentId, DocumentES document) {
        UpdateRequest updateRequest = new UpdateRequest(INDEX, TYPE, documentId).fetchSource(true); // fetch object after update
        Map<String, Object> error = new HashMap<>();
        error.put("Error", "unable to update docuemnt");
        try {
            String documentJson = objectMapper.writeValueAsString(document);
            updateRequest.doc(documentJson, XContentType.JSON);
            UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
            Map<String, Object> sourceAsMap = updateResponse.getGetResult().sourceAsMap();
            return sourceAsMap;
        } catch (JsonProcessingException e) {
            e.getMessage();
        } catch (java.io.IOException e) {
            e.getLocalizedMessage();
        }
        return error;
    }

    // delete document
    public void deleteDocumentById(String documentId) {
        DeleteRequest deleteRequest = new DeleteRequest(INDEX, TYPE, documentId);
        try {
            DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (java.io.IOException e) {
            e.getLocalizedMessage();
        }
    }


    // Search for query
    public String getDocumentsForQuery(String query, ArrayList<String> categoryList) {
        MultiSearchRequest request = new MultiSearchRequest();

        if (categoryList.isEmpty()) {


            SearchRequest firstSearchRequest = new SearchRequest(INDEX);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.matchQuery("summary", query));

            searchSourceBuilder.query(disMaxQuery()
                    .add(QueryBuilders.matchQuery("eventName", query))
                    .add(QueryBuilders.matchQuery("summary", query))
                    .add(QueryBuilders.matchQuery("text", query))
                    .boost(1.5f)
                    .tieBreaker(0.7f))
                    ;

           /*

           searchSourceBuilder.query(QueryBuilders.boolQuery().should(multiMatchQuery(query, "text","summary", "eventName")));

           this code is giving really bad relevance for the docuemnts. write about this in the report

            */

            firstSearchRequest.source(searchSourceBuilder);
            request.add(firstSearchRequest);
/*
            SearchRequest secondSearchRequest = new SearchRequest();
            searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.matchQuery("text", query)); // add boost
            secondSearchRequest.source(searchSourceBuilder);
            request.add(secondSearchRequest);

            SearchRequest thirdSearchRequest = new SearchRequest();
            searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.matchQuery("eventName", query));
            thirdSearchRequest.source(searchSourceBuilder);
            request.add(thirdSearchRequest);

 */


        } else {
            for (String category : categoryList) {
                SearchRequest categoryRequest = new SearchRequest();
                SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

                searchSourceBuilder.query(QueryBuilders.boolQuery()
                        .must(matchQuery("categoryID", category))
                        .must(matchQuery("eventName", query)) // why is there a must on the eventName?
                        .should(matchQuery("text", query))
                        .should(matchQuery("summary", query)));
                categoryRequest.source(searchSourceBuilder);
                request.add(categoryRequest);
            }
        }

        MultiSearchResponse searchResponse = null;

        try {
            searchResponse = restHighLevelClient.msearch(request, RequestOptions.DEFAULT);
        } catch (java.io.IOException e) {
            e.getLocalizedMessage();
        }
        MultiSearchResponse.Item items[] = searchResponse.getResponses();
        String json = "";
        Gson gson = new Gson();
        HashSet<String> eventNameSet = new HashSet();
        for (MultiSearchResponse.Item item : items) {
            SearchHits itemResponseHits = item.getResponse().getHits();
            SearchHit[] searchHits = itemResponseHits.getHits();
            for (int i = 0; i < searchHits.length; i++) {
                String temp = searchHits[i].getSourceAsString();
                SearchEntry searchEntry = gson.fromJson(temp, SearchEntry.class);
                if (!eventNameSet.contains(searchEntry.getEventName())) {
                    temp = temp + ",";
                    json += temp;
                    eventNameSet.add(searchEntry.getEventName());
                }
            }
        }
        json = json.substring(0, json.length() - 1);
        json = "[" + json + "]";
        return json;
    }
}
