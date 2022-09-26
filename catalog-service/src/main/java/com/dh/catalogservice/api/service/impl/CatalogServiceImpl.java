package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.api.service.feign.MovieFeignClient;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CatalogServiceImpl implements CatalogService {

	private final MovieFeignClient movieFeignClient;
	public static Logger LOG = LoggerFactory.getLogger(CatalogServiceImpl.class);

	@Autowired
	public CatalogServiceImpl(MovieFeignClient movieFeignClient) {
		this.movieFeignClient = movieFeignClient;
	}

	public CatalogWS findCatalogByGenre(String genre) {
		ResponseEntity<List<MovieWS>> movies = movieFeignClient.findCatalogByGenre(genre);
		LOG.info("Puerto del micro: "+movies.getHeaders().get("port"));
		if (movies.getStatusCode().is2xxSuccessful() && !movies.getBody().isEmpty()){
			return new CatalogWS(genre,movies.getBody());
		}
		return null;
	}


}
