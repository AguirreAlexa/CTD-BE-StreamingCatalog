package com.dh.serieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("series")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Serie {
    @Id
    private String id;
    private String name;
    private String genre;
    private List<Season> seasons;
}
