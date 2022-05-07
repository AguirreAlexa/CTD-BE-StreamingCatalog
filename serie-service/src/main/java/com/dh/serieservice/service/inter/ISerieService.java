package com.dh.serieservice.service.inter;

import com.dh.serieservice.model.Serie;

import java.util.List;

public interface ISerieService {
    List<Serie> getAll();
    List<Serie> getSeriesByGenre(String genre);
    Serie addSerie(Serie serie);
    Serie getSerieById(Integer id);
}
