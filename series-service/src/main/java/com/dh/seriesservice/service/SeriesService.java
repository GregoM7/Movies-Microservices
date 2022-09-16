package com.dh.seriesservice.service;

import com.dh.seriesservice.models.Series;
import com.dh.seriesservice.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SeriesService {
    private SeriesRepository seriesRepository;
    @Autowired
    public SeriesService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    private Integer id;
    public Series create(Series serie)  {
        if(Objects.isNull(id)){
            id=1;
        }else{
            id++;
        }
        serie.setId(id);
        return seriesRepository.save(serie);
    }

}
