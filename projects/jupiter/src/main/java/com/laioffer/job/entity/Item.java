package com.laioffer.job.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
    private String id;
    private String title;
    private String location;
    private String companyLogo;
    private String url;
    private String description;

    private Set<String> keywords;
    private boolean favorite;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("company_logo")
    public String getCompanyLogo() {
        return companyLogo;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

}
