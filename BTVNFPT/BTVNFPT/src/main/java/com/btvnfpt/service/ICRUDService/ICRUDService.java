package com.btvnfpt.service.ICRUDService;

import java.util.List;

public interface ICRUDService<E> {
    void add(E e);
    int findIndexById(int id);
    void edit(int id, E e);
    void delete(int id);
    List<E> getAll();
}
