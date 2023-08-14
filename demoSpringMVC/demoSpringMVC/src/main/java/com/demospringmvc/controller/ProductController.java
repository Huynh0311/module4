package com.demospringmvc.controller;

import com.demospringmvc.model.Product;
import com.demospringmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ModelAndView products() {
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAdd() {
        ModelAndView modelAndView = new ModelAndView("addProduct");
        return modelAndView;
    }

    @PostMapping("/add")
    public String Add(String name, int price, String img) {
        productService.add(new Product(name, price, img));
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("editProduct");
        modelAndView.addObject("products", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@RequestParam int id, String name, int price, String img) {
        productService.edit(new Product(id, name, price, img));
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(productService.findById(id));
        return "redirect:/products";
    }

    @GetMapping("/searchName")
    public ModelAndView findByName(String name){
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("products", productService.findByName(name));
        return modelAndView;
    }
}
