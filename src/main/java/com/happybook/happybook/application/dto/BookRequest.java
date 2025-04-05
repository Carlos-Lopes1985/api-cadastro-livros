package com.happybook.happybook.application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookRequest {

    private Integer edition;
    private String releaseDate;
    private String title;
    private String gener;
    private Long quantity;
    private String author;
    private BigDecimal price;
}
