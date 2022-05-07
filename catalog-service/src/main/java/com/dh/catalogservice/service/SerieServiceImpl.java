package com.dh.catalogservice.service;

import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.repository.ISerieRepository;
import com.dh.catalogservice.service.inter.ISerieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SerieServiceImpl implements ISerieService {
    private final ISerieRepository serieRepository;

    @Override
    public List<Serie> getSeriesByGenre(String genre) {
        return serieRepository.getSeries(genre);
    }

    @Override
    public List<Serie> getAllSeries() {
        return serieRepository.getAll();
    }

    @Override
    public Serie getSerieById(Integer id){
        Optional<Serie> serieFind = serieRepository.getSerieById(id);
        if(serieFind.isPresent()) {
            return serieFind.get();
        }else{
            return new Serie();
        }
    }

    @Override
    public Serie addSerie(Serie serie) {
        return serieRepository.addSerie(serie);
    }
}
