package com.github.macieryann.coincounselbudget.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "category")
public class CategoryEntity {
//    category_id SERIAL PRIMARY KEY,
//    name VARCHAR(50) NOT NULL,
//    description VARCHAR(255),
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    updated_at TIMESTAMP DEFAULT now()
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Instant createdAt;
    @Column
    private Instant updatedAt;

    public CategoryEntity() {

    }

    public CategoryEntity(int categoryId, String name, String description, Instant createdAt, Instant updatedAt) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
