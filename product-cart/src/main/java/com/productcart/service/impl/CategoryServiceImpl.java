package com.productcart.service.impl;

import com.studentmanager.model.Classroom;
import com.studentmanager.repository.IClassroomRepo;
import com.studentmanager.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassroomServiceImpl implements IClassroomService {
    @Autowired
    IClassroomRepo classroomRepo;
    @Override
    public List<Classroom> getAll() {
        return (List<Classroom>) classroomRepo.findAll();
    }
}
