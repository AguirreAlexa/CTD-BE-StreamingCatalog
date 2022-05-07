package com.dh.catalogservice.controller;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.service.GenreServiceImpl;
import com.dh.catalogservice.service.SerieServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
@AllArgsConstructor
public class SerieController {
    private SerieServiceImpl serieService;
    private GenreServiceImpl genreService;

    private static final Logger log = LoggerFactory.getLogger(SerieController.class);

    @GetMapping
    ResponseEntity<List<Serie>> getAllSeries(){
        return ResponseEntity.ok(serieService.getAllSeries());
    }

    @GetMapping("/{Serie}")
    ResponseEntity<List<Serie>> getSeriesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(serieService.getSeriesByGenre(genre));
    }

    @GetMapping("/id/{id}")
    ResponseEntity<Serie> getSerieById(@PathVariable Integer id){
        return ResponseEntity.ok(serieService.getSerieById(id));
    }

    @PostMapping
    ResponseEntity<Serie> addSerie(@RequestBody Serie Serie) {
        return ResponseEntity.ok(serieService.addSerie(Serie));
    }

//    //METODO PARA GUARDAR LA ENTIDAD
//    @RabbitListener(queues = {"${queue.serie.name}"})
//    public void receive(@Payload String serieId){
//        genreService.updateGenreBySerie(serieId);
//        log.info("Se guardo una serie en el catologo de " +  serieService.getSerieById(Integer.parseInt(serieId)).getGenre());
//    }
}
