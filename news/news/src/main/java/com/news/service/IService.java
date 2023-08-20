package com.news.service;

import java.util.List;

public interface IService<E> {
    void save(E e);
    void edit(E e);
    void delete(int id);
    E findById(int id);
    List<E> getAll();
}
