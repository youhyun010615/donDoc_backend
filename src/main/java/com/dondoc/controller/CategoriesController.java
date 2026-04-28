package com.dondoc.controller;

import com.dondoc.dto.Categories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @GetMapping
    public List<Categories> getCategories() {
        return Arrays.asList(
                new Categories(1L, "급여", "💰", "income"),
                new Categories(2L, "용돈", "🎁", "income"),
                new Categories(3L, "부업", "💼", "income"),
                new Categories(4L, "투자", "📈", "income"),
                new Categories(5L, "기타수입", "💵", "income"),
                new Categories(6L, "식비", "🍔", "expense"),
                new Categories(7L, "교통", "🚗", "expense"),
                new Categories(8L, "쇼핑", "🛍️", "expense"),
                new Categories(9L, "의료", "💊", "expense"),
                new Categories(10L, "문화", "🎬", "expense"),
                new Categories(11L, "통신", "📱", "expense"),
                new Categories(12L, "주거", "🏠", "expense"),
                new Categories(13L, "기타지출", "💸", "expense")
        );
    }

}
