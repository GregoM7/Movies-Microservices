package com.dh.seriesservice.service;

import com.dh.seriesservice.models.Series;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SerieCRUD<T> {

    public T create(T object);
    public T update(Series object, String name);
    public List<T> list(int from, int to);
    public T deleteName(String name);
    public T findByName(String name);

    public List<T> findByGenre(String genre,int from, int to);
}
