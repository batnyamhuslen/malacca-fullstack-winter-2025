package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "film")          // dvdrental database-ийн "film" table
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "rating")
    private String rating;

    @Column(name = "rental_rate")
    private java.math.BigDecimal rentalRate;

    // JPA заавал no-args constructor шаарддаг
    public Film() {
    }

    // Getters and setters
    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long id) {
        this.filmId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        this.title = t;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String r) {
        this.rating = r;
    }

    public java.math.BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(java.math.BigDecimal r) {
        this.rentalRate = r;
    }
}
