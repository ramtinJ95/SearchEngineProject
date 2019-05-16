package com.search.searchengine.model;

import java.io.Serializable;

public class Venue implements Serializable {
    private String name;
    private String age_restriction;
    private String capacity;
    private String id;
    private String resource_uri;
    private Address address;
    private String latitude;
    private String longitude;

    class Address implements Serializable {
        private String address_1;
        private String address_2;
        private String city;
        private String region;
        private String postal_code;
        private String country;
        private String latitude;
        private String longitude;
        private String localized_address_display;
        private String localized_area_display;
        private String[] localized_multi_line_address_display;

        public String getAddress_1() {
            return address_1;
        }

        public void setAddress_1(String address_1) {
            this.address_1 = address_1;
        }

        public String getAddress_2() {
            return address_2;
        }

        public void setAddress_2(String address_2) {
            this.address_2 = address_2;
        }

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

        public String getPostal_code() {
            return postal_code;
        }

        public void setPostal_code(String postal_code) {
            this.postal_code = postal_code;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
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

        public String getLocalized_address_display() {
            return localized_address_display;
        }

        public void setLocalized_address_display(String localized_address_display) {
            this.localized_address_display = localized_address_display;
        }

        public String getLocalized_area_display() {
            return localized_area_display;
        }

        public void setLocalized_area_display(String localized_area_display) {
            this.localized_area_display = localized_area_display;
        }

        public String[] getLocalized_multi_line_address_display() {
            return localized_multi_line_address_display;
        }

        public void setLocalized_multi_line_address_display(String[] localized_multi_line_address_display) {
            this.localized_multi_line_address_display = localized_multi_line_address_display;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge_restriction() {
        return age_restriction;
    }

    public void setAge_restriction(String age_restriction) {
        this.age_restriction = age_restriction;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResource_uri() {
        return resource_uri;
    }

    public void setResource_uri(String resource_uri) {
        this.resource_uri = resource_uri;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
