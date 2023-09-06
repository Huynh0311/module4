package com.productcart.repository;

import com.studentmanager.model.Classroom;
import org.springframework.data.repository.CrudRepository;

public interface IClassroomRepo extends CrudRepository<Classroom, Integer> {
}
