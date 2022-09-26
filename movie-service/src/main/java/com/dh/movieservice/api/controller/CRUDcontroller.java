package com.dh.movieservice.api.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CRUDcontroller<T> {
    public ResponseEntity<T> create(T object) ;
    public ResponseEntity<T> up(T object,String name) ;
    public ResponseEntity<List<T>> li(int from, int to) ;
    public ResponseEntity<T> deleteName(String name) ;
    public ResponseEntity<T> findByName(String name) ;
    public ResponseEntity<List<T>> findByGenre(String genre,int from,int to);
}
