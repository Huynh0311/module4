package com.demo_jpa.controller;

import com.demo_jpa.model.Category;
import com.demo_jpa.model.Product;
import com.demo_jpa.service.ICategoryService;
import com.demo_jpa.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    ICategoryService categoryService;
    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.getAll();
    }

    @GetMapping
    public ModelAndView getAll(@RequestParam(defaultValue = "0")int page){
        ModelAndView modelAndView = new ModelAndView("product");
        Page<Product> products = productService.getAll(PageRequest.of(page, 2, Sort.by("price")));
        modelAndView.addObject("products", products);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        productService.delete(id);
        return "redirect:/products";
    }
    @GetMapping("/add")
    public ModelAndView add(@ModelAttribute Product product){
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product, @RequestParam int idCategory){
        productService.save(product, idCategory);
        return "redirect:/products";

    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("editProduct");
        Product product = productService.findById(id);
        modelAndView.addObject("products", product);
        return modelAndView;
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product, @RequestParam int idCategory){
        productService.save(product, idCategory);
        return "redirect:/products";

    }
    @GetMapping("/search")
    public ModelAndView getAllById(@RequestParam String nameSearch, @RequestParam(defaultValue = "0")int page){
        ModelAndView modelAndView = new ModelAndView("product");

        Page<Product> products = productService.getAllByName(nameSearch,PageRequest.of(page, 2, Sort.by("price")));
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}
