package com.dh.seriesservice.models;

import java.util.List;

public class Seasons {
    private Integer id;
    private Integer seasonNum;
    private String genre;
    private List<Chapter> chapters;

    public Seasons() {
        //no-args constructor
    }

    public Seasons(Integer id, Integer seasonNum, String genre, List<Chapter> chapters) {
        this.id = id;
        this.seasonNum = seasonNum;
        this.genre = genre;
        this.chapters = chapters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeasonNum() {
        return seasonNum;
    }

    public void setSeasonNum(Integer seasonNum) {
        this.seasonNum = seasonNum;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}
