package com.example.model;

import java.math.BigDecimal;

public class Film {
    private Integer filmID;
    private String Title;
    private String  Rating;
    private BigDecimal ratingRate;

    public Integer getFilmID() {
        return filmID;
    }

    public BigDecimal getRatingRate() {
        return ratingRate;
    }

    public String getRating() {
        return Rating;
    }

    public String getTitle() {
        return Title;
    }

    public void setFilmID(Integer filmID) {
        this.filmID = filmID;
    }

    public void setRating(String Rating) {
        this.Rating = Rating;
    }

    public void setRentalRate(BigDecimal ratingRate) {
        this.ratingRate = ratingRate;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
    
    

}
