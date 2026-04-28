package com.dondoc.controller;

import com.dondoc.dto.Farms;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/farms")
public class FarmsController {

    @GetMapping
    public List<Farms> getFarms() {
        return Arrays.asList(
                new Farms(1L, "KB농장", LocalDateTime.now()),
                new Farms(2L, "신한농장", LocalDateTime.now()),
                new Farms(3L, "우리농장", LocalDateTime.now())
        );
    }
}