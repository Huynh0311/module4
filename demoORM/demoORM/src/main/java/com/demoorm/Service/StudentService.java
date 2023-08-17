package com.demoorm.Service;

import com.demoorm.dao.StudentDAO;
import com.demoorm.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDAO studentDAO;

    public List<Student> getAll(){
        return studentDAO.getAll();
    }
}
