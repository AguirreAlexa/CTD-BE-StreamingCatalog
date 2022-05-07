package com.dh.movieservice.service.inter;

import com.dh.movieservice.model.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieService<Movie> {
    List<Movie> getMoviesByGenre(String genre);
    List<Movie> getAllMovies();
    Movie addMovie(Movie movie);
    Movie getMovieById(Integer id);
}
