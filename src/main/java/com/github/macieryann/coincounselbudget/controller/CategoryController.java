package com.github.macieryann.coincounselbudget.controller;

import com.github.macieryann.coincounselbudget.common.StatusCode;
import com.github.macieryann.coincounselbudget.entity.CategoryEntity;
import com.github.macieryann.coincounselbudget.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
@Tag(name = "category controller")
public class CategoryController {
    //Retrieve a list of all budget categories
    //Create a new budget category
    //Update budget category details
    //Delete a budget category
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all-categories")
    public List<CategoryEntity> getCategories() {
        return categoryService.retrieveAllCategories();
    }

    @GetMapping("/{categoryId}")
    public CategoryEntity getCategoryById(@RequestParam int categoryId) {
        return categoryService.retrieveCatById(categoryId);
    }

    @PostMapping("/create-category")
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return categoryService.saveCategory(category);
    }

    @PostMapping("/update-category")
    public StatusCode updateCategory(@RequestBody CategoryEntity category) {
        return categoryService.editCategory(category);
    }

    @GetMapping("/delete-category")
    public String deleteCategory(@RequestParam int categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
}
