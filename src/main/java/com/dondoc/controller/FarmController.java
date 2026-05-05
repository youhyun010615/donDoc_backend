package com.dondoc.controller;

import com.dondoc.dto.FarmMembers;
import com.dondoc.dto.Farms;
import com.dondoc.repository.FarmRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/farm")
public class FarmController {

    private final FarmRepository farmRepository;
    private final ResourceUrlProvider resourceUrlProvider;

    public FarmController(FarmRepository farmRepository, ResourceUrlProvider resourceUrlProvider){
        this.farmRepository = farmRepository;
        this.resourceUrlProvider = resourceUrlProvider;
    }

    @GetMapping
    public List<Farms> getFarms() {
        return farmRepository.findAll();
    }

    @GetMapping("/members")
    public List<FarmMembers> getFarmMembers() {
        return farmRepository.findAllMembers();
    }
}
