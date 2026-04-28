package com.dondoc.controller;

import com.dondoc.dto.FarmMembers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/farmMembers")
public class FarmMembersController {

    @GetMapping
    public List<FarmMembers> getFarmMembers() {
        return Arrays.asList(
                new FarmMembers(1L, 1L, 1L, LocalDateTime.now()),
                new FarmMembers(2L, 2L, 1L, LocalDateTime.now()),
                new FarmMembers(3L, 3L, 2L, LocalDateTime.now()),
                new FarmMembers(4L, 1L, 2L, LocalDateTime.now()),
                new FarmMembers(5L, 4L, 3L, LocalDateTime.now())
        );
    }
}