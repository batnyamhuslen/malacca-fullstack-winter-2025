package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Film;
import com.example.repository.FilmRepository;

@RestController
@RequestMapping("/api")
public class FilmController {

    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        long count = filmRepository.countAll();
        return ResponseEntity.ok(Map.of("status", "up", "film_count", count));
    }

    @GetMapping("/film")
    public ResponseEntity<List<Film>> getFilms(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size) {
        int offset = (page - 1) * size;
        return ResponseEntity.ok(filmRepository.findAll(size, offset));
    }

    @GetMapping("/films/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable("id") int id) {
        return filmRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/films/top-rented")
    public ResponseEntity<List<Film>> getTopFilms(
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(filmRepository.findTopRented(limit));
    }

}
