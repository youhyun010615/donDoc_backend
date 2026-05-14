package com.dondoc.controller;

import com.dondoc.entity.FarmMember;
import com.dondoc.entity.Farm;
import com.dondoc.repository.FarmMemberRepository;
import com.dondoc.repository.FarmRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farm")
public class FarmController {

    private final FarmRepository farmRepository;
    private final FarmMemberRepository farmMemberRepository;

    public FarmController(FarmRepository farmRepository,  FarmMemberRepository farmMemberRepository){
        this.farmRepository = farmRepository;
        this.farmMemberRepository = farmMemberRepository;
    }

    @GetMapping
    public List<Farm> getFarms() {
        return farmRepository.findAll();
    }

    @GetMapping("/members")
    public List<FarmMember> getFarmMembers() {
        return farmMemberRepository.findAll();
    }

    @PostMapping
    public void createFarm(@RequestBody Farm farm){
        farmRepository.save(farm);
    }

    @PostMapping("/members")
    public void createFarmMember(@RequestBody FarmMember farmMember){
        farmMemberRepository.save(farmMember);
    }


}
