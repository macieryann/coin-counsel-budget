package com.github.macieryann.coincounselbudget.controller;

import com.github.macieryann.coincounselbudget.common.StatusCode;
import com.github.macieryann.coincounselbudget.entity.ExpenseEntity;
import com.github.macieryann.coincounselbudget.service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/expense")
@Tag(name = "expense controller")
public class ExpenseController {
    //Retrieve a list of all expenses for a user
    //Retrieve expense by expense ID
    //Create a new expense
    //TODO: Retrieve details of a specific expense
    //Update expense details
    //Delete an expense

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/all-expenses")
    public List<ExpenseEntity> getExpenses() {
        return expenseService.retrieveAllExpenses();
    }

    @GetMapping("/{expenseId}")
    public ExpenseEntity getExpenseById(@RequestParam int expenseId) {
        return expenseService.retrieveExpenseById(expenseId);
    }

    @PostMapping("/create-expense")
    public ExpenseEntity createExpense(@RequestBody ExpenseEntity expense) {
        return expenseService.saveExpense(expense);
    }

    @PostMapping("/update-expense")
    public StatusCode updateExpense(@RequestBody ExpenseEntity expenseEntity) {
        return expenseService.editExpense(expenseEntity);
    }

    @GetMapping("/delete-category")
    public String deleteExpense(@RequestParam int expenseId) {
        return expenseService.deleteExpense(expenseId);
    }

}
