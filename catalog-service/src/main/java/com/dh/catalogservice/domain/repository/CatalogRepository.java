package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.dto.CatalogWS;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends MongoRepository<CatalogWS, Integer> {

    Page findByGenre(String genre, PageRequest pageRequest);
}
