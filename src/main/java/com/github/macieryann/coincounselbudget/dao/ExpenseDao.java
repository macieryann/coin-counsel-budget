package com.github.macieryann.coincounselbudget.dao;

import com.github.macieryann.coincounselbudget.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExpenseDao extends JpaRepository<ExpenseEntity, Long> {
    @Query("SELECT MAX(e.expenseId) FROM ExpenseEntity e")
    int findMaxCategoryId();

    @Query("SELECT e FROM ExpenseEntity e WHERE e.expenseId = :expenseId")
    ExpenseEntity retrieveExpenseById(@Param("expenseId") int expenseId);
}
