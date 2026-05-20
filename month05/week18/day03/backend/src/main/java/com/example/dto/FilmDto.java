package com.example.dto;

import java.math.BigDecimal;

public class FilmDto {

    private Long filmId;
    private String title;
    private String description;
    private Integer releaseYear;
    private Integer length;
    private BigDecimal rental_Rate;
    private String rating;

    public FilmDto() {
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public BigDecimal getRentalRate() {
        return rental_Rate;
    }

    public void setRentalRate(BigDecimal rental_Rate) {
        this.rental_Rate = rental_Rate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
