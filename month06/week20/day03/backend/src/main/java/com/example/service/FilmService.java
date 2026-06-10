package com.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dto.FilmDto;
import com.example.model.Film;
import com.example.repository.FilmRepository;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Page<FilmDto> getFilms(String search, Pageable pageable) {
        Page<Film> films;
        if (search != null && !search.isEmpty()) {
            films = filmRepository.searchFilms(search, pageable);
        } else {
            films = filmRepository.findAll(pageable);
        }
        return films.map(this::convertToDto);
    }

    private FilmDto convertToDto(Film film) {
        FilmDto dto = new FilmDto();
        dto.setFilmId(film.getFilmId());
        dto.setTitle(film.getTitle());
        dto.setDescription(film.getDescription());
        dto.setReleaseYear(film.getReleaseYear());
        dto.setRentalRate(film.getRentalRate());
        dto.setRentalDuration(film.getRentalDuration());
        dto.setLength(film.getLength());
        dto.setReplacementCost(film.getReplacementCost());
        dto.setRating(film.getRating());
        return dto;
    }
}