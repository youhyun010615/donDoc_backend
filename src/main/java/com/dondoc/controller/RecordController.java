package com.dondoc.controller;

import com.dondoc.dto.Categories;
import com.dondoc.dto.MonthlyHistory;
import com.dondoc.dto.Records;
import com.dondoc.repository.RecordRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/record")
public class RecordController {

    private final RecordRepository recordRepository;

    public RecordController(RecordRepository recordRepository){
        this.recordRepository = recordRepository;
    }

    @GetMapping
    public List<Records> getRecords() {
        return recordRepository.findAll();
    }

    @GetMapping("/categories")
    public List<Categories> getCategories() {
        return Arrays.asList(
                new Categories(1L, "급여", "💰", "income"),
                new Categories(2L, "용돈", "🎁", "income"),
                new Categories(3L, "부업", "💼", "income"),
                new Categories(4L, "투자", "📈", "income"),
                new Categories(5L, "기타수입", "💵", "income"),
                new Categories(6L, "식비", "🍔", "expense"),
                new Categories(7L, "교통", "🚗", "expense"),
                new Categories(8L, "쇼핑", "🛍️", "expense"),
                new Categories(9L, "의료", "💊", "expense"),
                new Categories(10L, "문화", "🎬", "expense"),
                new Categories(11L, "통신", "📱", "expense"),
                new Categories(12L, "주거", "🏠", "expense"),
                new Categories(13L, "기타지출", "💸", "expense")
        );
    }

    @GetMapping("/monthly-history")
    public List<MonthlyHistory> getMonthlyHistory() {
        return Arrays.asList(
                new MonthlyHistory(1L, 1L, LocalDate.of(2026, 3, 1), 0.85f, 4),
                new MonthlyHistory(2L, 1L, LocalDate.of(2026, 4, 1), 0.92f, 3),
                new MonthlyHistory(3L, 2L, LocalDate.of(2026, 3, 1), 0.75f, 5),
                new MonthlyHistory(4L, 3L, LocalDate.of(2026, 4, 1), 1.05f, 3),
                new MonthlyHistory(5L, 4L, LocalDate.of(2026, 4, 1), 0.65f, 5)
        );
    }
}
