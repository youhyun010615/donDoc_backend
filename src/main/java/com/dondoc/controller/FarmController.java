package com.dondoc.controller;

import com.dondoc.dto.FarmMembers;
import com.dondoc.dto.Farms;
import com.dondoc.repository.FarmMembersRepository;
import com.dondoc.repository.FarmRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/farm")
public class FarmController {

    private final FarmRepository farmRepository;
    private final FarmMembersRepository farmMembersRepository;

    public FarmController(FarmRepository farmRepository,  FarmMembersRepository farmMembersRepository){
        this.farmRepository = farmRepository;
        this.farmMembersRepository = farmMembersRepository;
    }

    @GetMapping
    public List<Farms> getFarms() {
        return farmRepository.findAll();
    }

    @GetMapping("/members")
    public List<FarmMembers> getFarmMembers() {
        return farmMembersRepository.findAll();
    }
}
