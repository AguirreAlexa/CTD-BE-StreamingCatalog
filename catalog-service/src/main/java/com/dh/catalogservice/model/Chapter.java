package com.dh.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {
    @Id
    private Integer Id;
    private String name;
    private Integer number;
    private String urlStream;
}
