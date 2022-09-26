package com.dh.movieservice.api.service.impl;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService<Movie> {
	private MovieRepository movieRepository;
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository){
		this.movieRepository=movieRepository;
	}


	@Override
	public Movie create(Movie movie)  {

		if (exists(movie.getName())){
			throw new RuntimeException("La pelicula ya existe");
		}
		return movieRepository.save(movie);
	}

	private boolean exists(String name){
		return !movieRepository.findByName(name).isEmpty();
	}

	@Override
	public Movie update(Movie object, String name) {
		object.setId(findByName(name).getId());
		return movieRepository.save(object);
	}

	@Override
	public List<Movie> list(int from, int to)  {
		if(to-from>8) {
			throw new RuntimeException("No puedo llamar mas de 8 elementos");
		}

		Page page = movieRepository.findAll(PageRequest.of(from, to));

		if (page.isEmpty()) {
			throw new NotFoundException("No encontre ningun resultado");
		}

		return page.toList();
	}

	@Override
	public Movie deleteName(String name){
		Movie movie=findByName(name);
		movieRepository.deleteById(movie.getId());
		return movie;
	}

	@Override
	public Movie findByName(String name) {
		return movieRepository.findByName(name).orElseThrow(()->new NotFoundException("No existe pelicula con ese nombre"));
	}

	@Override
	public List<Movie> findByGenre(String genre,int from,int to) {
		if(to-from>8) {
			throw new RuntimeException("No puedo llamar mas de 8 elementos");
		}

		Page page = movieRepository.findByGenre(genre, PageRequest.of(from,to));

		if (page.isEmpty()) {
			throw new NotFoundException("No encontre ningun resultado");
		}

		return page.toList();
		}
}
