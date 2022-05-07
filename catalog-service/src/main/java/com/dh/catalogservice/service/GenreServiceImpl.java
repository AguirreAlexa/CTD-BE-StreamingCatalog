package com.dh.catalogservice.service;

import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.repository.IGenreRepository;
import com.dh.catalogservice.repository.IMovieRepository;
import com.dh.catalogservice.repository.ISerieRepository;
import com.dh.catalogservice.service.inter.IGenreService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements IGenreService {
    private final IGenreRepository genreRepository;
    private final MovieServiceImpl movieService;
    private final SerieServiceImpl serieService;

    @Override
    public Genre getGenre(String genre){
        return genreRepository.getGenreByGenre(genre);
    }

    @Override
    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    //METODOS DE PERSISTENCIA
    public void updateGenreByMovie(Integer movieId){
        Movie movieObject = movieService.getMovieById(movieId);
        Genre genreObject = getGenre(movieObject.getGenre());
        if(genreObject == null) {
           genreObject = new Genre(movieObject.getGenre());
        }
        genreObject.setMovies(movieObject);
        genreRepository.save(genreObject);
    }

    public void updateGenreBySerie(Integer serieId){
        Serie serieObject = serieService.getSerieById(serieId);
        Genre genreObject = getGenre(serieObject.getGenre());
        if(genreObject == null) {
            genreObject = new Genre(serieObject.getGenre());
        }
        genreObject.setSeries(serieObject);
        genreRepository.save(genreObject);
    }
}
