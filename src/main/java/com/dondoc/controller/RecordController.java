package com.dondoc.controller;

import com.dondoc.dto.Categories;
import com.dondoc.dto.MonthlyHistory;
import com.dondoc.dto.Records;
import com.dondoc.repository.CategoryRepository;
import com.dondoc.repository.MonthlyHistoryRepository;
import com.dondoc.repository.RecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/record")
public class RecordController {

    private final RecordRepository recordRepository;
    private final MonthlyHistoryRepository monthlyHistoryRepository;
    private final CategoryRepository categoryRepository;

    public RecordController(RecordRepository recordRepository, MonthlyHistoryRepository monthlyHistoryRepository, CategoryRepository categoryRepository){
        this.recordRepository = recordRepository;
        this.monthlyHistoryRepository = monthlyHistoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Records> getRecords() {
        return recordRepository.findAll();
    }

    @GetMapping("/categories")
    public List<Categories> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/monthly-history")
    public List<MonthlyHistory> getMonthlyHistory() {
        return monthlyHistoryRepository.findAll();
    }

    @PostMapping
    public void createRecord(@RequestBody Records record){
        recordRepository.save(record);
    }

    @PostMapping("/categories")
    public void createCategory(@RequestBody Categories category){
        categoryRepository.save(category);
    }

    @PostMapping("/monthly-history")
    public void createMonthlyHistory(@RequestBody MonthlyHistory monthlyHistory){
        monthlyHistoryRepository.save(monthlyHistory);
    }
}
