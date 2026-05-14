package com.dondoc.repository;

import com.dondoc.dto.Farms;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class FarmRepository {

    private final JdbcTemplate jdbcTemplate;

    public FarmRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Farms> findAll(){
        String sql = "SELECT * FROM farms";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Farms(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getObject("created_at", LocalDateTime.class)
        ));
    }

    public void save(Farms farm) {
        String sql = "INSERT INTO farms (name, created_at) VALUES (?, ?)";
        jdbcTemplate.update(sql, farm.getName(), farm.getCreatedAt());
    }
}
