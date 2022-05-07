package com.dh.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("genres")
@Data
@NoArgsConstructor
public class Genre {
    @Id
    private String id;
    private String genre;
    private List<Movie> movies;
    private List<Serie> series;

    public Genre(String genre) {
        this.genre = genre;
        this.movies = new ArrayList<>();
        this.series = new ArrayList<>();
    }

    public void setMovies(Movie movie) {
        movies.add(movie);
    }

    public void setSeries(Serie serie) {
        series.add(serie);
    }
}
