package com.github.macieryann.coincounselbudget.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "expense")
public class ExpenseEntity {
    //    expense_id SERIAL PRIMARY KEY,
    //    category_id INT,
    //    amount DECIMAL(10, 2),
    //    date DATE,
    //    description VARCHAR(255),
    //    payment_method VARCHAR(50),
    //    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    //    updated_at TIMESTAMP DEFAULT now(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int expenseId;

    @Column
    private int categoryId;
    @Column
    private double amount;
    @Column
    private Instant date;
    @Column
    private String description;
    @Column
    private String paymentMethod;
    @Column
    private Instant createdAt;

    @Column
    private Instant updatedAt;

    public ExpenseEntity() {

    }

    public ExpenseEntity(int expenseId, int categoryId, double amount, Instant date, String description, String paymentMethod, Instant createdAt, Instant updatedAt) {
        this.expenseId = expenseId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }


}
