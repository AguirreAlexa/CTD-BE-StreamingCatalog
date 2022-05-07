package com.dh.catalogservice.repository;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@FeignClient(name="serie-service")
public interface ISerieRepository {

    @GetMapping("/series")
    List<Serie> getAll();

    @GetMapping("/series/{genre}")
    List<Serie> getSeries(@PathVariable String genre);

    @GetMapping("/series/id/{id}")
    Optional<Serie> getSerieById(@PathVariable Integer id);

    @PostMapping("/series")
    Serie addSerie(Serie serie);
}
