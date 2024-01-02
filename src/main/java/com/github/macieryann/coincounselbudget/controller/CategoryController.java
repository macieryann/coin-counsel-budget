package com.github.macieryann.coincounselbudget.controller;

import com.github.macieryann.coincounselbudget.entity.CategoryEntity;
import com.github.macieryann.coincounselbudget.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
@Tag(name = "category controller")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @GetMapping("/test-postgres")
    public List<CategoryEntity> testPostgres() {
        return categoryService.retrieveAllCategories();
    }
}
