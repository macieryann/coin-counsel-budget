package com.github.macieryann.coincounselbudget.dao;

import com.github.macieryann.coincounselbudget.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {
    @Query("SELECT MAX(c.categoryId) FROM CategoryEntity c")
    int findMaxCategoryId();

    @Query("SELECT c FROM CategoryEntity c WHERE c.categoryId = :categoryId")
    CategoryEntity retrieveCategoryById(@Param("categoryId") int categoryId);
}
