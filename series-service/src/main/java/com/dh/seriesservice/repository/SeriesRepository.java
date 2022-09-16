package com.dh.seriesservice.repository;


import com.dh.seriesservice.models.Series;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends MongoRepository<Series, Integer> {
}
