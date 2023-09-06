package com.productcart.repository;

import com.studentmanager.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepo extends CrudRepository<Student, Integer> {
    @Query(value = "select s from product s where s.name like concat('%', :name, '%') ")
    List<Student> findAllByName(@Param("name") String name);
}
