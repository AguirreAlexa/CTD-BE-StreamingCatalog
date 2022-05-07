package com.dh.catalogservice.repository;

import com.dh.catalogservice.model.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IGenreRepository extends MongoRepository<Genre, Integer> {
    Genre getGenreByGenre(String genre);

}
