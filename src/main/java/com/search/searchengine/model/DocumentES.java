package com.search.searchengine.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DocumentES {

    private String id;
    private String eventName;
    private float price;

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getEventName() {
        return eventName;
    }

    public String getId() {
        return id;
    }
}
