package com.dh.catalogservice.repository;

import com.dh.catalogservice.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@FeignClient(name="movie-service")
public interface IMovieRepository {

    @GetMapping("/movies")
    List<Movie> getAll();

    @GetMapping("/movies/{genre}")
    List<Movie> getMoviesByGenre(@PathVariable String genre);

    @GetMapping("/movies/id/{id}")
    Optional<Movie> getMovieById(@PathVariable Integer id);

    @PostMapping("/movies")
    Movie addMovie(Movie movie);
}
