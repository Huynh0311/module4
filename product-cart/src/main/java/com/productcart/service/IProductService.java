package com.productcart.service;

import com.studentmanager.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    Student save(Student student);
    void delete(int id);
    Student findById(int id);
    List<Student> findAllByName(String name);
}
