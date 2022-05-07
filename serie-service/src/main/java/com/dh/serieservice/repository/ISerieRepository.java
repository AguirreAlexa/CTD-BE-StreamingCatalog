package com.dh.serieservice.repository;

import com.dh.serieservice.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ISerieRepository extends MongoRepository<Serie, Integer> {

    List<Serie> getSeriesByGenre(String genre);
}
