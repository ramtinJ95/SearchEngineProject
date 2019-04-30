package com.search.searchengine.model;

import java.io.Serializable;
import java.util.List;

public class EventWrapper implements Serializable {
    private List<Event> events;

    private Location location;

    class Location implements Serializable {
        String latitude;
        AugmentedLocation augmented_location;

        class AugmentedLocation implements Serializable {
            String city;
            String region;
            String country;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }
        }

        String within;
        String longitude;
        String address;

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public AugmentedLocation getAugmented_location() {
            return augmented_location;
        }

        public void setAugmented_location(AugmentedLocation augmented_location) {
            this.augmented_location = augmented_location;
        }

        public String getWithin() {
            return within;
        }

        public void setWithin(String within) {
            this.within = within;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    private Pagination pagination;

    class Pagination implements Serializable {
        Integer object_count;
        Integer page_number;
        Integer page_size;
        Integer page_count;
        Boolean has_more_items;

        public Integer getObject_count() {
            return object_count;
        }

        public void setObject_count(Integer object_count) {
            this.object_count = object_count;
        }

        public Integer getPage_number() {
            return page_number;
        }

        public void setPage_number(Integer page_number) {
            this.page_number = page_number;
        }

        public Integer getPage_size() {
            return page_size;
        }

        public void setPage_size(Integer page_size) {
            this.page_size = page_size;
        }

        public Integer getPage_count() {
            return page_count;
        }

        public void setPage_count(Integer page_count) {
            this.page_count = page_count;
        }

        public Boolean getHas_more_items() {
            return has_more_items;
        }

        public void setHas_more_items(Boolean has_more_items) {
            this.has_more_items = has_more_items;
        }
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
