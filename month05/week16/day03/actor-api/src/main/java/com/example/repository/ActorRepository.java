package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.model.Actor;

@Repository
public class ActorRepository {

    private final JdbcTemplate jdbc;

    public ActorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public int update(int id, Actor actor) {
        String sql = "update actor set first_name = ?, last_name = ? where actor_id = ?";
        return jdbc.update(sql, actor.getFirstName(), actor.getLastName(), id);
    }

    public Actor create(Actor actor) {
        String sql = """
                   insert into actor (first_name,last_name)
                   values (?,?)
                """;
        jdbc.update(sql, actor.getFirstName(), actor.getLastName());

        return actor;
    }

    public List<Actor> findAll() {
        return jdbc.query(
                "select actor_id, first_name, last_name from actor order by last_name",
                actorRowMapper());
    }

    public Optional<Actor> findById(int id) {
        try {
            return Optional.ofNullable(
                    jdbc.queryForObject(
                            """
                select actor_id, first_name, last_name
                from actor
                where actor_id = ?
            """,
                            actorRowMapper(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private RowMapper<Actor> actorRowMapper() {
        return (rs, rowNum) -> {
            Actor a = new Actor();
            a.setActorId(rs.getInt("actor_id"));
            a.setFirstName(rs.getString("first_name"));
            a.setLastName(rs.getString("last_name"));
            return a;
        };
    }
}
