package com.demo_jpa.service;

import java.util.List;

public interface IService<E> {
    void save(E e);
    void edit(E e);
    void delete(int id);
    List<E> getAll();
    E findById(int id);
}
