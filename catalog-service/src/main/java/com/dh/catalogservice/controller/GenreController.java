package com.dh.catalogservice.controller;

import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.service.GenreServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
@AllArgsConstructor
public class GenreController {
    private GenreServiceImpl genreService;

    @GetMapping
    ResponseEntity<List<Genre>> getAllGenres(){
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @GetMapping("/{genre}")
    ResponseEntity<Genre> getGenre(@PathVariable String genre) {
        return ResponseEntity.ok(genreService.getGenre(genre));
    }
}
