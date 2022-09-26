package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.impl.CatalogServiceImpl;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("catalog")
public class CatalogControllerImpl implements CatalogController{

    private CatalogServiceImpl catalogServiceImpl;

    @Autowired
    public CatalogControllerImpl(CatalogServiceImpl catalogServiceImp) {
        this.catalogServiceImpl = catalogServiceImp;
    }

    @Override
    @GetMapping("movies/list")
    public ResponseEntity<List<MovieWS>> listMovies(@RequestParam("from") int from, @RequestParam("to") int to) {
        return ResponseEntity.ok(catalogServiceImpl.listMovies(from, to));
    }

    @Override
    @GetMapping("movies/findByName/{name}")
    public ResponseEntity<MovieWS> findMovieByName(@PathVariable String name)  {
        return ResponseEntity.ok(catalogServiceImpl.findMovieByName(name));
    }

    @Override
    @GetMapping("movies/findByGenre/{genre}")
    public ResponseEntity<List<MovieWS>> findMoviesByGenre(@PathVariable String genre,@RequestParam("from") int from,@RequestParam("to") int to) {
        return ResponseEntity.ok(catalogServiceImpl.findMoviesByGenre(genre, from, to));
    }

    @Override
    @GetMapping("series/list")
    public ResponseEntity<List<SerieWS>> listSeries(@RequestParam("from") int from, @RequestParam("to") int to) {
        return (ResponseEntity<List<SerieWS>>) catalogServiceImpl.listSeries(from, to);
    }

    @Override
    @GetMapping("series/findByName/{name}")
    public ResponseEntity<SerieWS> findSerieByName(@PathVariable String name) {
        return ResponseEntity.ok(catalogServiceImpl.findSerieByName(name));
    }

    @Override
    @GetMapping("series/findByGenre/{genre}")
    public ResponseEntity<List<SerieWS>> findSerieByGenre(@PathVariable String genre,@RequestParam("from") int from,@RequestParam("to") int to) {
        return ResponseEntity.ok(catalogServiceImpl.findSerieByGenre(genre, from, to));
    }

}
