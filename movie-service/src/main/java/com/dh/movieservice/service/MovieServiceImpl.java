package com.dh.movieservice.service;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.repository.IMovieRepository;
import com.dh.movieservice.service.inter.IMovieService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ConstructorBinding
@Service
public class MovieServiceImpl implements IMovieService<Movie> {

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findMoviesByGenre(genre);
    }

    @Override
    public Movie addMovie(Movie movie) {
        Movie movieObject = movieRepository.save(movie);
        rabbitTemplate.convertAndSend("movieQueue", movieObject.getId().toString());
        return movieObject;
    }

    @Override
    public Movie getMovieById(Integer id){
        Optional<Movie> movieFind = movieRepository.findById(id);
        if(movieFind.isPresent()) {
            return movieFind.get();
        }else{
            return new Movie();
        }
    }

    @Override
    @CircuitBreaker(name="movies",fallbackMethod = "getMoviesFallbackMethod")
    @Retry(name="movies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // METODO DE EXCEPCION
    private List<Movie> getMoviesFallbackMethod(CallNotPermittedException exception){
        log.error("Circuit breaker fue activado", exception.getMessage());
        System.out.println("Fallback executed");
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie());
        return movieList;
    }
}
