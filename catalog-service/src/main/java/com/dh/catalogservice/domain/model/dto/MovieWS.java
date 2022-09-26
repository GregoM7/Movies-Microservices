package com.dh.catalogservice.domain.model.dto;

import lombok.Data;

@Data
public class MovieWS {

    private Integer id;
    private String name;
    private String genre;
    private String urlStream;
}
