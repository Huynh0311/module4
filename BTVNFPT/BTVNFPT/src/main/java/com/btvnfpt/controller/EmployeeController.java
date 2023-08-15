package com.btvnfpt.controller;

import com.btvnfpt.model.Branch;
import com.btvnfpt.model.Employee;
import com.btvnfpt.service.BranchService;
import com.btvnfpt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    BranchService branchService;

    @ModelAttribute(name = "branches")
    public List<Branch> branches() {
        branchService = new BranchService();
        return branchService.getAll();
    }

    @GetMapping("/add")
    public ModelAndView showFormAdd() {
        ModelAndView modelAndView = new ModelAndView("addEmployee");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/add")
    public String add(@RequestParam MultipartFile fileImg, @ModelAttribute Employee employee, @RequestParam int idBranch) {
        try {
            String nameFile = fileImg.getOriginalFilename();
            fileImg.transferTo(new File("D:/Code-Gym/Module4/BTVNFPT/BTVNFPT/src/main/webapp/img/" + nameFile));
            Branch branch = branchService.findById(idBranch);
            employee.setBranch(branch);
            employee.setImg("/img/" + nameFile);
            employeeService.add(employee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/employees";
    }

    @GetMapping("/edit/{idEmployee}")
    public ModelAndView showFormEdit(@PathVariable int idEmployee) {
        ModelAndView modelAndView = new ModelAndView("editEmployee");
        modelAndView.addObject("employee", employeeService.findById(idEmployee));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Employee employee, @RequestParam MultipartFile fileImg, @RequestParam int idBranch) {
        try {
            String nameFile = fileImg.getOriginalFilename();
            fileImg.transferTo(new File("D:/Code-Gym/Module4/BTVNFPT/BTVNFPT/src/main/webapp/img/" + nameFile));
            employee.setImg(nameFile);
            Branch branch = branchService.findById(idBranch);
            employee.setBranch(branch);
            employeeService.edit(employee.getIdEmployee(), employee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/employees";
    }

    @GetMapping("/delete/{idEmployee}")
    public String delete(@PathVariable int idEmployee) {
        employeeService.delete(idEmployee);
        return "redirect:/employees";
    }

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("employee");
        modelAndView.addObject("employees", employeeService.getAll());
        return modelAndView;
    }
}
