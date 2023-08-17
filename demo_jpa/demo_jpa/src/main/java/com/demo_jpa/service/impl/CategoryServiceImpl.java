package com.demo_jpa.service.impl;

import com.demo_jpa.model.Category;
import com.demo_jpa.repository.ICategoryRepo;
import com.demo_jpa.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepo iCategoryRepo;
    @Override
    public void save(Category category) {

    }

    @Override
    public void edit(Category category) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) iCategoryRepo.findAll();
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepo.findById(id).get();
    }
}
