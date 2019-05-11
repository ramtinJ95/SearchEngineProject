package com.search.searchengine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class FrontendQuery implements Serializable {
    private String query;
    private ArrayList<String> categorieIDs;
    private boolean isLocataionChecked;
    private String latitude;
    private String longitude;
    private Date fromDate;
    private Date toDate;


    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ArrayList<String> getCategorieIDs() {
        return categorieIDs;
    }

    public void setCategorieIDs(ArrayList<String> categorieIDs) {
        this.categorieIDs = categorieIDs;
    }

    public boolean isLocataionChecked() {
        return isLocataionChecked;
    }

    public void setLocataionChecked(boolean locataionChecked) {
        isLocataionChecked = locataionChecked;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }



}
