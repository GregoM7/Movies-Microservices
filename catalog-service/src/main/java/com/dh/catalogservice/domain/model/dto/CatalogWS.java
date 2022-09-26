package com.dh.catalogservice.domain.model.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data @Builder
@Document
public class CatalogWS {
	@Id
	private Integer id;
	private String genre;
	private MovieWS movies;

	public CatalogWS() {
	}

	public CatalogWS(String genre, MovieWS movies) {
		this.genre = genre;
		this.movies = movies;
	}
}
