package com.dondoc.repository;

import com.dondoc.dto.FarmMembers;
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

    public List<FarmMembers> findAllMembers(){
        String sql = "SELECT * FROM farm_members";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new FarmMembers(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("farm_id"),
                rs.getObject("joined_at", LocalDateTime.class)
        ));
    }
}
