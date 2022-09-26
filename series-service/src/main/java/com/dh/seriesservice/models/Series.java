package com.dh.seriesservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Series {
    @Id
    private Integer id;
    private String name;
    private String genre;
    private List<Seasons> seasons;

    public Series() {
        //no-args constructor
    }

    public Series(Integer id, String name, String genre, List<Seasons> seasons) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.seasons = seasons;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Seasons> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Seasons> seasons) {
        this.seasons = seasons;
    }
}
