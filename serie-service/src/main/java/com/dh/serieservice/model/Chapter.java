package com.dh.serieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("chapters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {
    @Id
    private String Id;
    private String name;
    private Integer number;
    private String urlStream;
}
