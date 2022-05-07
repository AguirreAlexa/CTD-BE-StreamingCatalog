package com.dh.catalogservice.configuration;

import com.dh.catalogservice.service.GenreServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ConsumerMessageService {
    private GenreServiceImpl genreService;

    public void consumerMessage(String msg) {
        Integer id = Integer.parseInt(msg.substring(msg.indexOf(":")+1));

        if (msg.contains("movie")) {
            log.info("La película se agrego exitosamente al servicio. id: " + id);
            genreService.updateGenreByMovie(id);
        }else if (msg.contains("serie")) {
            log.info("La película se agrego exitosamente al servicio. id: " + id);
            genreService.updateGenreBySerie(id);
        }
    }
}
