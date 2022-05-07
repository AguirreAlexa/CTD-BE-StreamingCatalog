package com.dh.serieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("seasons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Season {
    @Id
    private String id;
    private Integer seasonNumber;
    private List<Chapter> chapters;
}
