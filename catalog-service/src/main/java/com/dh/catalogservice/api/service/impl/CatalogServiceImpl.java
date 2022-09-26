package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.api.service.feign.MovieFeignClient;
import com.dh.catalogservice.api.service.feign.SerieFeignClient;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

	public MovieFeignClient movieFeignClient;

	public SerieFeignClient serieFeignClient;

	@Autowired
	public CatalogServiceImpl(MovieFeignClient movieFeignClient,SerieFeignClient serieFeignClient){
		this.movieFeignClient=movieFeignClient;
		this.serieFeignClient=serieFeignClient;
	}

	@Override
	public List<MovieWS> listMovies(int from, int to) {
		return movieFeignClient.li(from,to).getBody();
	}

	@Override
	public MovieWS findMovieByName(String name) {
		return movieFeignClient.findByName(name).getBody();
	}

	@Override
	public List<MovieWS> findMoviesByGenre(String genre,int from, int to)  {
		return movieFeignClient.findByGenre(genre,from,to).getBody();
	}

	@Override
	public List<SerieWS> listSeries(int from, int to)  {
		return serieFeignClient.li(from, to).getBody();
	}

	@Override
	public SerieWS findSerieByName(String name) {
		return serieFeignClient.findByName(name).getBody();
	}

	@Override
	public List<SerieWS> findSerieByGenre(String genre, int from, int to) {
		return serieFeignClient.findByGenre(genre, from, to).getBody();
	}

}
