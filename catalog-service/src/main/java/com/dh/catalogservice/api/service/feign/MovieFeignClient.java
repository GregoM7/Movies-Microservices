package com.dh.catalogservice.api.service.feign;

import com.dh.catalogservice.api.service.feign.config.FeignConfig;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "movie-service")
@LoadBalancerClient(name = "movie-service", configuration = FeignConfig.class)
public interface MovieFeignClient {

    @GetMapping("movies/list")
    public ResponseEntity<List<MovieWS>> li(@RequestParam("from") int from, @RequestParam("to") int to) ;

    @GetMapping("movies/findByName/{name}")
    public ResponseEntity<MovieWS> findByName(@PathVariable String name);

    @GetMapping("movies/findByGenre/{genre}")
    public ResponseEntity<List<MovieWS>> findByGenre(@PathVariable String genre,@RequestParam("from") int from,@RequestParam("to") int to);
}
