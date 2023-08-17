package com.demoorm.dao;

import com.demoorm.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDAO {
    SessionFactory sessionFactory;
    public List<Student> getAll(){
        Session session = sessionFactory.openSession();
        List<Student> students = session.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        return students;
    }
}
