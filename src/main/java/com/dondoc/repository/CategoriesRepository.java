package com.dondoc.repository;

import com.dondoc.dto.Categories;
import com.dondoc.dto.FarmMembers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CategoriesRepository {

    private final JdbcTemplate jdbcTemplate;

    public CategoriesRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public List<Categories> findAll(){
        String sql = "SELECT * FROM categories";
        return jdbcTemplate.query(sql, (rs,rowNum) -> new Categories(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("icon"),
                rs.getString("type")
        ));
    }

}
