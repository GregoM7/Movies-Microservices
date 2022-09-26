package com.dh.catalogservice.domain.model.dto;

import lombok.Data;

@Data
public class SeasonWS {
    private Integer id;
    private Integer seasonNum;
    private ChapterWS chapter;
}
