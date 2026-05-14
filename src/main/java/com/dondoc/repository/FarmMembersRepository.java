package com.dondoc.repository;

import com.dondoc.dto.FarmMembers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class FarmMembersRepository {

    private final JdbcTemplate jdbcTemplate;

    public FarmMembersRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public List<FarmMembers> findAll(){
        String sql = "SELECT * FROM farm_members";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new FarmMembers(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("farm_id"),
                rs.getObject("joined_at", LocalDateTime.class)
        ));
    }
}
