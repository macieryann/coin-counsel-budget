package com.github.macieryann.coincounselbudget.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/expense")
@Tag(name = "expense controller")
public class ExpenseController {

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }
}
