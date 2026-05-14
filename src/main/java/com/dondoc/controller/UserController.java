package com.dondoc.controller;

import com.dondoc.dto.Users;
import com.dondoc.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

// ddddd
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Users> getUsers(){
        return userRepository.findAll();
    }

    // PostMapping - POST 요청을 받는 엔드포인트
    // @RequestBody - 요청 body의 JSON을 Users 객체로 변환
    @PostMapping
    public void createUser(@RequestBody Users user){
        userRepository.save(user);
    }
}
