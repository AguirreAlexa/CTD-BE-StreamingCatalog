package com.dh.catalogservice.controller;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.service.GenreServiceImpl;
import com.dh.catalogservice.service.MovieServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {
    private MovieServiceImpl movieService;

    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @GetMapping
    ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }

    @GetMapping("/id/{id}")
    ResponseEntity<Movie> getMovieById(@PathVariable Integer id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PostMapping
    ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }
}
