package com.productcart.controller;

import com.studentmanager.model.Classroom;
import com.studentmanager.model.Student;
import com.studentmanager.service.IClassroomService;
import com.studentmanager.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class StudentController {
    @Autowired
    IStudentService studentService;
    @Autowired
    IClassroomService classroomService;
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> studentList = studentService.getAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    @GetMapping("/classrooms")
    public ResponseEntity<List<Classroom>> getAllClassroom() {
        List<Classroom> classrooms = classroomService.getAll();
        if (classrooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }
    @PostMapping("/addStudent")
    public void save(@RequestBody Student student){
        studentService.save(student);
    }
    @GetMapping("showEdit/{idS}")
    public Student showEdit(@PathVariable int idS){
        return studentService.findById(idS);
    }
    @PostMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.delete(id);
    }
    @GetMapping("/searchByName/{name}")
    public List<Student> findAllByName(@PathVariable String name){
        return studentService.findAllByName(name);
    }
}
