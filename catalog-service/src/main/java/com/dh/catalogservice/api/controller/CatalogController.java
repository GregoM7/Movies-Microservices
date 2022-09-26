package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface CatalogController {

	public ResponseEntity<List<MovieWS>> listMovies(int from, int to);

	public ResponseEntity<MovieWS> findMovieByName(String name);

	public ResponseEntity<List<MovieWS>> findMoviesByGenre(String genre,int from, int to) ;

	public ResponseEntity<List<SerieWS>> listSeries(int from, int to) ;

	public ResponseEntity<SerieWS> findSerieByName(String name) ;

	public ResponseEntity<List<SerieWS>> findSerieByGenre(String genre,int from, int to) ;

}
