package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;

import java.util.List;

public interface CatalogService {

    public List<MovieWS> listMovies(int from, int to) ;

    public MovieWS findMovieByName(String name) ;

    public List<MovieWS> findMoviesByGenre(String genre,int from, int to) ;

    public List<SerieWS> listSeries(int from, int to) ;

    public SerieWS findSerieByName(String name) ;

    public List<SerieWS> findSerieByGenre(String genre,int from, int to) ;
}
