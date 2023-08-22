package com.news.repository;

import com.news.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface INewsRepo extends PagingAndSortingRepository<News, Integer> {
    List<News> findAllByCategoryIdCategory(int idCategory);
    @Query(value = "select n from News n where n.title like concat('%', :title, '%') ")
    Page<News> getAllByTitle(@Param("title") String titleSearch, Pageable pageable);
}
