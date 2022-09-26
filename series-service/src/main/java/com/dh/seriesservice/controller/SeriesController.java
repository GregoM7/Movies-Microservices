package com.dh.seriesservice.controller;

import com.dh.seriesservice.models.Series;
import com.dh.seriesservice.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("series")
public class SeriesController implements ControllerCRUD<Series> {

    private SeriesService serieService;

    @Autowired
    public SeriesController(SeriesService serieService){
        this.serieService=serieService;
    }
    @Override
    @PostMapping("/create")
    public ResponseEntity<Series> create(@RequestBody Series object)  {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(serieService.create(object));
    }

    @Override
    @PutMapping("/update/{name}")
    public ResponseEntity<Series> up(@RequestBody Series object,@PathVariable String name)  {
        return ResponseEntity.ok(serieService.update(object,name));
    }

    @Override
    @GetMapping("/list")
    public ResponseEntity<List<Series>> li(@RequestParam("from") int from, @RequestParam("to") int to)  {
        return ResponseEntity.ok(serieService.list(from,to));
    }

    @Override
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Series> deleteName(@PathVariable String name) {
        return ResponseEntity.ok(serieService.deleteName(name));
    }

    @Override
    @GetMapping("/findByName/{name}")
    public ResponseEntity<Series> findByName(@PathVariable String name){
        return ResponseEntity.ok(serieService.findByName(name));
    }

    @Override
    @GetMapping("/findByGenre/{genre}")
    public ResponseEntity<List<Series>> findByGenre(@PathVariable String genre,@RequestParam("from") int from,@RequestParam("to") int to){
        return ResponseEntity.ok(serieService.findByGenre(genre, from, to));
    }

}
