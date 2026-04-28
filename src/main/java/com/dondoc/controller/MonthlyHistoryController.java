package com.dondoc.controller;

import com.dondoc.dto.MonthlyHistory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/monthlyHistory")
public class MonthlyHistoryController {

    @GetMapping
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