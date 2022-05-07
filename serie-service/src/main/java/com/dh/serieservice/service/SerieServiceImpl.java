package com.dh.serieservice.service;

import com.dh.serieservice.model.Serie;
import com.dh.serieservice.repository.ISerieRepository;
import com.dh.serieservice.service.inter.ISerieService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SerieServiceImpl implements ISerieService {
    public final ISerieRepository serieRepository;
    public final RabbitTemplate rabbitTemplate;

    @Override
    public List<Serie> getAll() {
        return serieRepository.findAll();
    }

    @Override
    public List<Serie> getSeriesByGenre(String genre) {
        return serieRepository.getSeriesByGenre(genre);
    }

    @Override
    public Serie getSerieById(Integer id){
        Optional<Serie> serieFind = serieRepository.findById(id);
        if(serieFind.isPresent()) {
            return serieFind.get();
        }else{
            return new Serie();
        }
    }

    @Override
    public Serie addSerie(Serie serie) {
        Serie serieObject = serieRepository.save(serie);
        rabbitTemplate.convertAndSend("serieQueue", serieObject.getId());
        return serieObject;
    }
}
