package com.example.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dto.FilmDto;
import com.example.model.Film;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Page<FilmDto> getFilms(String search, Pageable pageable) {
        Page<Film> filmPage;
        if (search == null || search.trim().isEmpty()) {
            filmPage = filmRepository.findAll(pageable);
        } else {
            filmPage = filmRepository.searchFilms(search, pageable);
        }
        return filmPage.map(this::convertToDto);
    }

    private FilmDto convertToDto(Film film) {
        FilmDto dto = new FilmDto();           
        dto.setFilmId(film.getFilmId());
        dto.setTitle(film.getTitle());
        dto.setDescription(film.getDescription());
        dto.setReleaseYear(film.getReleaseYear());
        dto.setLength(film.getLength());
        dto.setRentalRate(film.getRentalRate());
        dto.setRating(film.getRating());
        return dto;                           
    }
}