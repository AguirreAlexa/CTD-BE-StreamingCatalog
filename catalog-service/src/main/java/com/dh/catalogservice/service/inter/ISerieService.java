package com.dh.catalogservice.service.inter;

import com.dh.catalogservice.model.Serie;

import java.util.List;

public interface ISerieService {
    List<Serie> getSeriesByGenre(String genre);
    List<Serie> getAllSeries();
    Serie addSerie(Serie serie);
    Serie getSerieById(Integer id);
}
