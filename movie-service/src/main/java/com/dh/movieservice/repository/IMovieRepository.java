package com.dh.movieservice.repository;

import com.dh.movieservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findMoviesByGenre(String genre);
}
