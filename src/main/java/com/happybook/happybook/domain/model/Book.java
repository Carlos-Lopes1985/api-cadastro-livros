package com.happybook.happybook.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class Book {

    private Long id;
    private Integer edition;
    private String releaseDate;
    private String title;
    private String gener;
    private Long quantity;
    private String author;
    private BigDecimal price;

    public Book(Long id, Integer edition, String releaseDate, String title, String gener, Long quantity, String author, BigDecimal price) {
        this.id = id;
        this.edition = edition;
        this.releaseDate = releaseDate;
        this.title = title;
        this.gener = gener;
        this.quantity = quantity;
        this.author = author;
        this.price = price;
    }

    public Book(Long id, String title, String gener, Long quantity, String author) {
        this.id = id;
        this.title = title;
        this.gener = gener;
        this.quantity = quantity;
        this.author = author;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
