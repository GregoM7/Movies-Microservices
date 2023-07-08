package com.dh.seriesservice.service;

import com.dh.seriesservice.models.Series;
import com.dh.seriesservice.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Objects;

@Service
public class SeriesService implements SerieCRUD<Series>{
    private SeriesRepository seriesRepository;
    @Autowired
    public SeriesService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    private Integer id;
    @Override
    public Series create(Series serie)  {
        if(Objects.isNull(id)){
            id=1;
        }else{
            id++;
        }
        serie.setId(id);
        if(exists(serie.getName())) throw new RuntimeException("La serie ya existe");
        return seriesRepository.save(serie);
    }

    private boolean exists(String name){
        return !seriesRepository.findByName(name).isEmpty();
    }


    @Override
    public Series update(Series object, String name) {
        object.setId(findByName(name).getId());
        return seriesRepository.save(object);
    }

    @Override
    public List list(int from, int to) {
        if(to-from>8) {
            throw new RuntimeException("No puedo llamar mas de 8 elementos");
        }

        Page page = seriesRepository.findAll(PageRequest.of(from, to));

        if (page.isEmpty()) {
            throw new NotFoundException("No se encontro ningun elemento");
        }

        return page.toList();
    }
    @Override
    public Series deleteName(String name) {
        Series serie=findByName(name);
        seriesRepository.deleteById(serie.getId());
        return serie;
    }

    @Override
    public Series findByName(String name) {
        return seriesRepository.findByName(name).orElseThrow(()->new NotFoundException("No hay una serie con ese nombre"));
    }

    @Override
    public List findByGenre(String genre, int from, int to) {
        if(to-from>8) {
            throw new RuntimeException("No puedo llamar mas de 8 elementos");
        }

        Page page = seriesRepository.findByGenre(genre,PageRequest.of(from, to));

        if (page.isEmpty()) {
            throw new NotFoundException("No se encontro ningun elemento");
        }

        return page.toList();
    }
}
