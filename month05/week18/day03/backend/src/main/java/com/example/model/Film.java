package com.example.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="film")
public class Film {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="film_id")
    private Long filmId;

    private String title;
    private String description;

    @Column(name="release_year", columnDefinition="year")
    private Integer releaseYear;

    @Column(name="rental_rate")
    private BigDecimal rentalRate;
    
    @Column(name="rental_duration")
    private Integer rentalDuration;

    private Integer length;

    @Column(name="replacement_cost")
    private BigDecimal replacementCost;

    @Column(name="rating", columnDefinition="mpaa_rating")
    private String rating;

    public Film(){}
    

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }



}