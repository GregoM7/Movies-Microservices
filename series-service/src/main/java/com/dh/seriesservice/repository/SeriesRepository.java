package com.dh.seriesservice.repository;


import com.dh.seriesservice.models.Series;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeriesRepository extends MongoRepository<Series, Integer> {
    Optional<Series> findByName(String name);
    Page findByGenre(String genre, PageRequest pageRequest);
}
