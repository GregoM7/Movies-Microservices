package com.dh.seriesservice.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ControllerCRUD<T>{

    public ResponseEntity<T> create(T object) ;
    public ResponseEntity<T> up(T object,String name) ;
    public ResponseEntity<List<T>> li(int from, int to) ;
    public ResponseEntity<T> deleteName(String name) ;
    public ResponseEntity<T> findByName(String name) ;
    public ResponseEntity<List<T>> findByGenre(String genre,int from,int to);
}
