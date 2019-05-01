package com.search.searchengine;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.search.searchengine.model.Event;
import com.search.searchengine.model.EventWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@EnableJpaAuditing
public class SearchEngineApplication {



    public static void main(String[] args) {
        SpringApplication.run(SearchEngineApplication.class, args);
    }

}
