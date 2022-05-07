package com.dh.catalogservice.service;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.repository.IMovieRepository;
import com.dh.catalogservice.service.inter.IMovieService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements IMovieService {
    private final IMovieRepository movieRepository;

    @Override
    public List<Movie> getMoviesByGenre(String genre){
        return movieRepository.getMoviesByGenre(genre);
    }

    @Override
    public Movie getMovieById(Integer id){
        Optional<Movie> movieFind = movieRepository.getMovieById(id);
        if(movieFind.isPresent()) {
            return movieFind.get();
        }else{
            return new Movie();
        }
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.getAll();
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }
}
