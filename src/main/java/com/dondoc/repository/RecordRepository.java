package com.dondoc.repository;

import com.dondoc.dto.Categories;
import com.dondoc.dto.MonthlyHistory;
import com.dondoc.dto.Records;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class RecordRepository {

    private final JdbcTemplate jdbcTemplate;

    public RecordRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Records> findAll(){
        String sql = "SELECT * FROM records";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Records(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("category_id"),
                rs.getLong("amount"),
                rs.getString("description"),
                rs.getString("memo"),
                rs.getObject("record_date", LocalDate.class),
                rs.getObject("created_at", LocalDateTime.class)
        ));
    }

    public List<Categories> findAllCategories(){
        String sql = "SELECT * FROM categories";
        return jdbcTemplate.query(sql, (rs,rowNum) -> new Categories(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("icon"),
                rs.getString("type")
        ));
    }
    public List<MonthlyHistory> findAllMonthlyHistory(){
        String sql = "SELECT * FROM monthly_history";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new MonthlyHistory(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getObject("target_month", LocalDate.class),
                rs.getFloat("avg_ratio"),
                rs.getInt("house_level")
        ));
    }
}
