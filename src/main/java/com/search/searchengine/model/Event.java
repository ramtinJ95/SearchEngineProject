package com.search.searchengine.model;

import java.io.Serializable;

public class Event implements Serializable {
    private Name name;
    private Description description;
    private String organization_id;
    private String created;
    private String changed;
    private String published;
    private String capacity;
    private Boolean capacity_is_custom;
    private String status;
    private String currency;
    private String USD;
    private Boolean listed;
    private Boolean shareable;
    private Boolean online_event;
    private Integer tx_time_limit;
    private Boolean hide_start_date;
    private Boolean hide_end_date;
    private String locale;
    private Boolean is_locked;
    private String privacy_setting;
    private Boolean is_series;
    private Boolean is_series_parent;
    private String inventory_type;
    private Boolean is_reserved_seating;
    private Boolean show_pick_a_seat;
    private Boolean show_seatmap_thumbnail;
    private Boolean show_colors_in_seatmap_thumbnail;
    private String source;
    private Boolean is_free;
    private String version;
    private String summary;
    private String logo_id;
    private String organizer_id;
    private String venue_id;
    private String category_id;
    private String subcategory_id;
    private String format_id;
    private String resource_uri;
    private Boolean is_externally_ticketed;
    private Logo logo;
    private String id;
    private String url;
    private String vanity_url;
    private Time start;
    private Time end;

    class Name implements Serializable {
        String text;
        String html;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }
    }

    public String getName() {
        return name.getText();
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getDescription() {
        return description.text;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVanity_url() {
        return vanity_url;
    }

    public void setVanity_url(String vanity_url) {
        this.vanity_url = vanity_url;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public String getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(String organization_id) {
        this.organization_id = organization_id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Boolean getCapacity_is_custom() {
        return capacity_is_custom;
    }

    public void setCapacity_is_custom(Boolean capacity_is_custom) {
        this.capacity_is_custom = capacity_is_custom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUSD() {
        return USD;
    }

    public void setUSD(String USD) {
        this.USD = USD;
    }

    public Boolean getListed() {
        return listed;
    }

    public void setListed(Boolean listed) {
        this.listed = listed;
    }

    public Boolean getShareable() {
        return shareable;
    }

    public void setShareable(Boolean shareable) {
        this.shareable = shareable;
    }

    public Boolean getOnline_event() {
        return online_event;
    }

    public void setOnline_event(Boolean online_event) {
        this.online_event = online_event;
    }

    public Integer getTx_time_limit() {
        return tx_time_limit;
    }

    public void setTx_time_limit(Integer tx_time_limit) {
        this.tx_time_limit = tx_time_limit;
    }

    public Boolean getHide_start_date() {
        return hide_start_date;
    }

    public void setHide_start_date(Boolean hide_start_date) {
        this.hide_start_date = hide_start_date;
    }

    public Boolean getHide_end_date() {
        return hide_end_date;
    }

    public void setHide_end_date(Boolean hide_end_date) {
        this.hide_end_date = hide_end_date;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Boolean getIs_locked() {
        return is_locked;
    }

    public void setIs_locked(Boolean is_locked) {
        this.is_locked = is_locked;
    }

    public String getPrivacy_setting() {
        return privacy_setting;
    }

    public void setPrivacy_setting(String privacy_setting) {
        this.privacy_setting = privacy_setting;
    }

    public Boolean getIs_series() {
        return is_series;
    }

    public void setIs_series(Boolean is_series) {
        this.is_series = is_series;
    }

    public Boolean getIs_series_parent() {
        return is_series_parent;
    }

    public void setIs_series_parent(Boolean is_series_parent) {
        this.is_series_parent = is_series_parent;
    }

    public String getInventory_type() {
        return inventory_type;
    }

    public void setInventory_type(String inventory_type) {
        this.inventory_type = inventory_type;
    }

    public Boolean getIs_reserved_seating() {
        return is_reserved_seating;
    }

    public void setIs_reserved_seating(Boolean is_reserved_seating) {
        this.is_reserved_seating = is_reserved_seating;
    }

    public Boolean getShow_pick_a_seat() {
        return show_pick_a_seat;
    }

    public void setShow_pick_a_seat(Boolean show_pick_a_seat) {
        this.show_pick_a_seat = show_pick_a_seat;
    }

    public Boolean getShow_seatmap_thumbnail() {
        return show_seatmap_thumbnail;
    }

    public void setShow_seatmap_thumbnail(Boolean show_seatmap_thumbnail) {
        this.show_seatmap_thumbnail = show_seatmap_thumbnail;
    }

    public Boolean getShow_colors_in_seatmap_thumbnail() {
        return show_colors_in_seatmap_thumbnail;
    }

    public void setShow_colors_in_seatmap_thumbnail(Boolean show_colors_in_seatmap_thumbnail) {
        this.show_colors_in_seatmap_thumbnail = show_colors_in_seatmap_thumbnail;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getIs_free() {
        return is_free;
    }

    public void setIs_free(Boolean is_free) {
        this.is_free = is_free;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLogo_id() {
        return logo_id;
    }

    public void setLogo_id(String logo_id) {
        this.logo_id = logo_id;
    }

    public String getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(String organizer_id) {
        this.organizer_id = organizer_id;
    }

    public String getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(String venue_id) {
        this.venue_id = venue_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(String subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    public String getFormat_id() {
        return format_id;
    }

    public void setFormat_id(String format_id) {
        this.format_id = format_id;
    }

    public String getResource_uri() {
        return resource_uri;
    }

    public void setResource_uri(String resource_uri) {
        this.resource_uri = resource_uri;
    }

    public Boolean getIs_externally_ticketed() {
        return is_externally_ticketed;
    }

    public void setIs_externally_ticketed(Boolean is_externally_ticketed) {
        this.is_externally_ticketed = is_externally_ticketed;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }


    class Description implements Serializable {
        String text;
        String html;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }
    }

    class Time implements Serializable {
        String timezone;
        String local;
        String utc;

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getLocal() {
            return local;
        }

        public void setLocal(String local) {
            this.local = local;
        }

        public String getUtc() {
            return utc;
        }

        public void setUtc(String utc) {
            this.utc = utc;
        }
    }


    class Logo implements Serializable {
        CropMask crop_mask;

        class CropMask implements Serializable {
            TopLeft top_left;

            public TopLeft getTop_left() {
                return top_left;
            }

            public void setTop_left(TopLeft top_left) {
                this.top_left = top_left;
            }

            public Integer getWidth() {
                return width;
            }

            public void setWidth(Integer width) {
                this.width = width;
            }

            public Integer getHeight() {
                return height;
            }

            public void setHeight(Integer height) {
                this.height = height;
            }

            class TopLeft implements Serializable {
                Integer x;

                public Integer getX() {
                    return x;
                }

                public void setX(Integer x) {
                    this.x = x;
                }

                public Integer getY() {
                    return y;
                }

                public void setY(Integer y) {
                    this.y = y;
                }

                Integer y;
            }

            Integer width;
            Integer height;
        }

        Original original;

        public CropMask getCrop_mask() {
            return crop_mask;
        }

        public void setCrop_mask(CropMask crop_mask) {
            this.crop_mask = crop_mask;
        }

        public Original getOriginal() {
            return original;
        }

        public void setOriginal(Original original) {
            this.original = original;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAspect_ratio() {
            return aspect_ratio;
        }

        public void setAspect_ratio(String aspect_ratio) {
            this.aspect_ratio = aspect_ratio;
        }

        public String getEdge_color() {
            return edge_color;
        }

        public void setEdge_color(String edge_color) {
            this.edge_color = edge_color;
        }

        public Boolean getEdge_color_set() {
            return edge_color_set;
        }

        public void setEdge_color_set(Boolean edge_color_set) {
            this.edge_color_set = edge_color_set;
        }

        class Original implements Serializable {
            String url;
            Integer width;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public Integer getWidth() {
                return width;
            }

            public void setWidth(Integer width) {
                this.width = width;
            }

            public Integer getHeight() {
                return height;
            }

            public void setHeight(Integer height) {
                this.height = height;
            }

            Integer height;
        }

        String id;
        String url;
        String aspect_ratio;
        String edge_color;
        Boolean edge_color_set;
    }
}
