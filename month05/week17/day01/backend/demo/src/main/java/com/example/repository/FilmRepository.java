package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
    
}