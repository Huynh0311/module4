package com.news.service.impl;

import com.news.model.Category;
import com.news.model.News;
import com.news.repository.ICategoryRepo;
import com.news.repository.INewsRepo;
import com.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    ICategoryRepo iCategoryRepo;
    @Autowired
    INewsRepo iNewsRepo;

    @Override
    public void save(News news) {
        iNewsRepo.save(news);
    }

    @Override
    public void edit(News news) {
        iNewsRepo.save(news);
    }

    @Override
    public void delete(int id) {
        iNewsRepo.deleteById(id);
    }

    @Override
    public News findById(int id) {
        Optional<News> optionalNews = iNewsRepo.findById(id);
        if (optionalNews.isPresent()) {
            return optionalNews.get();
        } else {
            return new News();
        }
    }

    @Override
    public List<News> getAll() {
        return (List<News>) iNewsRepo.findAll();
    }

    @Override
    public void save(News news, int idCategory) {
        Category category = iCategoryRepo.findById(idCategory).get();
        news.setCategory(category);
        iNewsRepo.save(news);
    }

    @Override
    public Page<News> getAll(Pageable pageable, String nameSearch) {
        return null;
    }
}
