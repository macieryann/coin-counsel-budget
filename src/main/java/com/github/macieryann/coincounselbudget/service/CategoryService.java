package com.github.macieryann.coincounselbudget.service;

import com.github.macieryann.coincounselbudget.dao.CategoryDao;
import com.github.macieryann.coincounselbudget.entity.CategoryEntity;
import com.github.macieryann.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends CrudService<CategoryEntity, Long> {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        super(categoryDao);
        this.categoryDao = categoryDao;
    }

    public List<CategoryEntity> retrieveAllCategories() {
        return categoryDao.findAll();
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
}
