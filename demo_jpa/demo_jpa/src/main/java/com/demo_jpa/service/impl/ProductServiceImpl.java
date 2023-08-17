package com.demo_jpa.service.impl;

import com.demo_jpa.model.Product;
import com.demo_jpa.repository.ICategoryRepo;
import com.demo_jpa.repository.IProductRepo;
import com.demo_jpa.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ICategoryRepo iCategoryRepo;
    @Autowired
    IProductRepo iProductRepo;

    @Override
    public void save(Product product, int idCategory) {
        product.setCategory(iCategoryRepo.findById(idCategory).get());
        iProductRepo.save(product);
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return iProductRepo.findAll(pageable);
    }

    @Override
    public List<Product> getAllByName(String name) {
        return iProductRepo.getAllByNameSQL(name);
    }

    @Override
    public void save(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public void edit(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public void delete(int id) {
        iProductRepo.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) iProductRepo.findAll();
    }

    @Override
    public Product findById(int id) {
        Optional<Product> productOptional = iProductRepo.findById(id);
        if (productOptional.isPresent()) {
            return productOptional.get();
        } else {
            return new Product();
        }
    }
    @Override
    public Page<Product> getAllByName(String name, Pageable pageable){
        return iProductRepo.getAllByNameHQL(name, pageable);
    }
}
