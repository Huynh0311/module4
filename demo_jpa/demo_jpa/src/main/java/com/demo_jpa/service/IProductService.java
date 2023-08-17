package com.demo_jpa.service;

import com.demo_jpa.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IService<Product> {
    void save(Product product, int idCategory);
    Page<Product> getAll(Pageable pageable);
    List<Product> getAllByName(String name);
    Page<Product> getAllByName(String name, Pageable pageable);
}
