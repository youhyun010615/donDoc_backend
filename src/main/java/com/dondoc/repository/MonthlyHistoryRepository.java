package com.dondoc.repository;

import com.dondoc.dto.MonthlyHistory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MonthlyHistoryRepository {

    private final JdbcTemplate jdbcTemplate;

    public MonthlyHistoryRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public List<MonthlyHistory> findAll(){
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
