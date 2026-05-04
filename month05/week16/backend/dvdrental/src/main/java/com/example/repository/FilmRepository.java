package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.model.Film;

@Repository
public class FilmRepository {

    private final JdbcTemplate jdbcTemplate;

    public FilmRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long countAll() {
        return jdbcTemplate.queryForObject("select count(*) from film", Long.class);
    }

    public List<Film> findAll(int limit, int offset) {
        String sql = """
                        select film_id, title, rating, rental_rate
                        from film
                        order by title
                        limit ? offset ?
                     """;
        return jdbcTemplate.query(sql, filmRowMapper(), limit, offset);
    }

    public Optional<Film> findById(int filmId) {
        String sql = """
                        select film_id, title, rating, rental_rate
                        from film
                        where film_id = ?
                     """;
        try {
            Film film = jdbcTemplate.queryForObject(sql, filmRowMapper(), filmId);
            return Optional.ofNullable(film);
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public List<Film> findByTitle(String title) {
        String sql = """
                        select film_id, title, rating, rental_rate
                        from film
                        where title ILIKE ?
                     """;
        return jdbcTemplate.query(sql, filmRowMapper(), "%" + title + "%");
    }

    private RowMapper<Film> filmRowMapper() {
        return (rs, rowNum) -> {
            Film f = new Film();
            f.setFilmID(rs.getInt("film_id"));
            f.setTitle(rs.getString("title"));
            f.setRating(rs.getString("rating"));
            f.setRentalRate(rs.getBigDecimal("rental_rate"));
            return f;
        };
    }
}