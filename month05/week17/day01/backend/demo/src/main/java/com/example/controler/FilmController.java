package com.example.controler;

import com.example.model.Film;
import com.example.repository.FilmRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/films")
@CrossOrigin(origins = "*")   // TypeScript frontend-аас дуудах зөвшөөрөл
public class FilmController {

    private final FilmRepository filmRepo;

    public FilmController(FilmRepository filmRepo) { this.filmRepo = filmRepo; }

    @GetMapping
    public ResponseEntity<List<Film>> getAll() {
        // JdbcTemplate: jdbc.query(sql, mapper, limit, offset)
        // JPA:          filmRepo.findAll()  ← SQL автоматаар
        return ResponseEntity.ok(filmRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getById(@PathVariable Long id) {
        // JdbcTemplate: try { jdbc.queryForObject(...) } catch (EmptyResult...)
        // JPA:          filmRepo.findById(id) → Optional<Film>
        return filmRepo.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
