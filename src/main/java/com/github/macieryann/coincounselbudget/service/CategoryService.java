package com.github.macieryann.coincounselbudget.service;

import com.github.macieryann.coincounselbudget.common.StatusCode;
import com.github.macieryann.coincounselbudget.dao.CategoryDao;
import com.github.macieryann.coincounselbudget.entity.CategoryEntity;

import com.github.macieryann.coincounselbudget.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class CategoryService extends CrudService<CategoryEntity, Long> {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        super(categoryDao);
        this.categoryDao = categoryDao;
    }

    @Override
    public void updateFields(CategoryEntity requestEntity, CategoryEntity fetchedEntity) {
        // category_id, name, description, created_at, updated_at
        fetchedEntity.setCategoryId(requestEntity.getCategoryId());
        fetchedEntity.setName(requestEntity.getName());
        fetchedEntity.setDescription(requestEntity.getDescription());
        fetchedEntity.setCreatedAt(requestEntity.getCreatedAt());
        fetchedEntity.setUpdatedAt(requestEntity.getUpdatedAt());
    }

    public List<CategoryEntity> retrieveAllCategories() {
        return categoryDao.findAll();
    }

    public CategoryEntity retrieveCatById(int id) {
        return categoryDao.retrieveCategoryById(id);
    }

    public CategoryEntity saveCategory(CategoryEntity category) {
        int maxCategoryId = categoryDao.findMaxCategoryId();

        category.setCategoryId(maxCategoryId + 1);
        category.setCreatedAt(Instant.now());
        category.setUpdatedAt(Instant.now());

        return categoryDao.save(category);
    }

    public StatusCode editCategory(CategoryEntity category) {
        int id = category.getCategoryId();
        category.setName(category.getName());
        category.setDescription(category.getDescription());
        category.setUpdatedAt(Instant.now());

        return super.editEntity((long) id, category);
    }

    public String deleteCategory(int id) {
        categoryDao.deleteById((long) id);
        return "category deleted";
    }

}
