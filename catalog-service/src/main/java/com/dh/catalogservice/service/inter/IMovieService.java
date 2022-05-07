package com.dh.catalogservice.service.inter;

import com.dh.catalogservice.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> getMoviesByGenre(String genre);
    List<Movie> getAllMovies();
    Movie addMovie(Movie movie);
    Movie getMovieById(Integer id);
}
