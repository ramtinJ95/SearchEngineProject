package com.search.searchengine.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.search.searchengine.model.DocumentES;
import com.search.searchengine.utility.Utilities;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Repository;

import java.util.*;

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
    public String getDocumentsForQuery(String query) {
        SearchRequest searchRequest = new SearchRequest(INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.size(100);
        searchSourceBuilder.query(QueryBuilders.matchQuery("eventName", query));
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = null;

        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (java.io.IOException e) {
            e.getLocalizedMessage();
        }
        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHits = hits.getHits();
        List<String> resultList = new ArrayList<>();
        for (SearchHit searchHit : searchHits) {
            resultList.add(searchHit.getSourceAsString());
        }
        Gson gson = new Gson();
        String json = gson.toJson(resultList);
        return json;
    }
}