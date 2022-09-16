package com.dh.seriesservice.service;

import com.dh.seriesservice.models.Series;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SeriesServiceTest {

    @Autowired
    private SeriesService seriesservice;



    @Test
    void create() {
        Series serie1 = new Series();
        serie1.setName("Friends");
        serie1.setGenre("Comedy");
        Assertions.assertTrue(seriesservice.create(serie1).getName().equals("Friends"));
    }
}