package com.dh.catalogservice.service.inter;

import com.dh.catalogservice.model.Genre;

import java.util.List;

public interface IGenreService {
    Genre getGenre(String genre);
    List<Genre> getAllGenres();
}
