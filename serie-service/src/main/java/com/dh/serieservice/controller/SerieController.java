package com.dh.serieservice.controller;

import com.dh.serieservice.model.Serie;
import com.dh.serieservice.service.SerieServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
@AllArgsConstructor
public class SerieController {
    private SerieServiceImpl serieService;

    @GetMapping
    ResponseEntity<List<Serie>> getAllSeries(){
        return ResponseEntity.ok(serieService.getAll());
    }

    @GetMapping("/{genre}")
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
}
