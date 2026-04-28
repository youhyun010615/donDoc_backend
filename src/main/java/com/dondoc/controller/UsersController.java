package com.dondoc.controller;

import com.dondoc.dto.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @GetMapping
    public List<Users> getUsers(){
        return Arrays.asList(
                new Users(1L, "kyujin123", "pass1", "최규진", 25, 1, 1, 3000000L, 6, LocalDateTime.now()),
                new Users(2L, "spring_fan", "pass2", "김철수", 22, 2, 1, 2500000L, 5, LocalDateTime.now()),
                new Users(3L, "java_master", "pass3", "이영희", 27, 3, 2, 4000000L, 7, LocalDateTime.now()),
                new Users(4L, "dondoc_user", "pass4", "박민수", 24, 1, 1, 2000000L, 4, LocalDateTime.now()),
                new Users(5L, "tester01", "pass5", "정다은", 26, 2, 2, 3500000L, 8, LocalDateTime.now())
        );
    }
}
