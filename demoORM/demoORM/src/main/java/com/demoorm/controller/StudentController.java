package com.demoorm.controller;

import com.demoorm.Service.StudentService;
import com.demoorm.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("studentHome");
        List<Student> students =  studentService.getAll();
        modelAndView.addObject("students", students);
        return modelAndView;
    }
}
