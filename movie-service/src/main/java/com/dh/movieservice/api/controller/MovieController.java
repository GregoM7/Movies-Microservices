package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.api.service.impl.MovieServiceImpl;
import com.dh.movieservice.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController implements CRUDcontroller<Movie>{

	private MovieServiceImpl movieService;

	@Autowired
	public MovieController(MovieServiceImpl movieService){
		this.movieService=movieService;
	}


	@Override
	@PostMapping("/create")
	public ResponseEntity<Movie> create(@RequestBody Movie object)  {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(movieService.create(object));
	}

	@Override
	@PutMapping("/update/{name}")
	public ResponseEntity<Movie> up(@RequestBody Movie object,@PathVariable String name)  {
		return ResponseEntity.ok(movieService.update(object,name));
	}

	@Override
	@GetMapping("/list")
	public ResponseEntity<List<Movie>> li(@RequestParam("from") int from, @RequestParam("to") int to)  {
		return ResponseEntity.ok(movieService.list(from,to));
	}

	@Override
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<Movie> deleteName(@PathVariable String name){
		return ResponseEntity.ok(movieService.deleteName(name));
	}

	@Override
	@GetMapping("/findByName/{name}")
	public ResponseEntity<Movie> findByName(@PathVariable String name) {
		return ResponseEntity.ok(movieService.findByName(name));
	}

	@Override
	@GetMapping("/findByGenre/{genre}")
	public ResponseEntity<List<Movie>> findByGenre(@PathVariable String genre,@RequestParam("from") int from,@RequestParam("to") int to)  {
		return ResponseEntity.ok(movieService.findByGenre(genre, from, to));
	}



}
