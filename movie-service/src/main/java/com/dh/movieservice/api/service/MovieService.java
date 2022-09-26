package com.dh.movieservice.api.service;

import com.dh.movieservice.domain.model.Movie;

import java.util.List;

public interface MovieService<T> {
	public T create(T object);
	public T update(T object,String name) ;
	public List<T> list(int from, int to) ;
	public T deleteName(String name) ;
	public T findByName(String name) ;
	public List<T> findByGenre(String genre,int from, int to);
}
