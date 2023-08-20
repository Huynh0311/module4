package com.news.service.impl;

import com.news.model.Category;
import com.news.repository.ICategoryRepo;
import com.news.repository.INewsRepo;
import com.news.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    INewsRepo iNewsRepo;
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
        iNewsRepo.deleteById(id);
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) iCategoryRepo.findAll();
    }
}
