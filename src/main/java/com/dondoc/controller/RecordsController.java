package com.dondoc.controller;

import com.dondoc.dto.Records;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordsController {

    @GetMapping
    public List<Records> getRecords() {
        return Arrays.asList(
                new Records(1L, 1L, 6L, 15000L, "점심 식사", "회사 근처 식당", LocalDate.of(2026, 4, 21), LocalDateTime.now()),
                new Records(2L, 1L, 7L, 50000L, "택시비", "야근 후 택시", LocalDate.of(2026, 4, 20), LocalDateTime.now()),
                new Records(3L, 2L, 1L, 3000000L, "월급", "4월 급여", LocalDate.of(2026, 4, 1), LocalDateTime.now()),
                new Records(4L, 1L, 8L, 80000L, "옷 구매", "봄 옷", LocalDate.of(2026, 4, 19), LocalDateTime.now()),
                new Records(5L, 3L, 6L, 5000L, "커피", "스타벅스", LocalDate.of(2026, 4, 22), LocalDateTime.now())
        );
    }
}
