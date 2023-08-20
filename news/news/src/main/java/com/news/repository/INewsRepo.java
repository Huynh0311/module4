package com.news.repository;

import com.news.model.News;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface INewsRepo extends PagingAndSortingRepository<News, Integer> {
}
