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
        return recordRepository.findAllCategories();
    }

    @GetMapping("/monthly-history")
    public List<MonthlyHistory> getMonthlyHistory() {
        return recordRepository.findAllMonthlyHistory();
    }
}
