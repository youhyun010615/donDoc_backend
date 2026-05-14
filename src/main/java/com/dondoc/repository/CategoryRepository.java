package com.dondoc.repository;

import com.dondoc.dto.Categories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    public CategoryRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public List<Categories> findAll(){
        String sql = "SELECT * FROM categories";
        return jdbcTemplate.query(sql, (rs,rowNum) -> new Categories(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("icon"),
                rs.getString("type")
        ));
    }

    public void save(Categories category) {
        String sql = "INSERT INTO categories (name, icon, type) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, category.getName(), category.getIcon(), category.getType());
    }
}
