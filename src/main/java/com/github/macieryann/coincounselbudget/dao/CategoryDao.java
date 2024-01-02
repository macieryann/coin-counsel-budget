package com.github.macieryann.coincounselbudget.dao;

import com.github.macieryann.coincounselbudget.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {

}
