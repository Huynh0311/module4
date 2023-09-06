package com.productcart.service.impl;

import com.studentmanager.model.Student;
import com.studentmanager.repository.IStudentRepo;
import com.studentmanager.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    IStudentRepo studentRepo;
    @Override
    public List<Student> getAll() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student findById(int id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public List<Student> findAllByName(String name) {
        return studentRepo.findAllByName(name);
    }
}
