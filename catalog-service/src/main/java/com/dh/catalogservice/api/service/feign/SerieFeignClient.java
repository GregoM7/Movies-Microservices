package com.dh.catalogservice.api.service.feign;


import com.dh.catalogservice.domain.model.dto.SerieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "serie-service")
public interface SerieFeignClient {

    @GetMapping("series/list")
    public ResponseEntity<List<SerieWS>> li(@RequestParam("from") int from, @RequestParam("to") int to);

    @GetMapping("series/findByName/{name}")
    public ResponseEntity<SerieWS> findByName(@PathVariable String name);

    @GetMapping("series/findByGenre/{genre}")
    public ResponseEntity<List<SerieWS>> findByGenre(@PathVariable String genre,@RequestParam("from") int from,@RequestParam("to") int to);
}
