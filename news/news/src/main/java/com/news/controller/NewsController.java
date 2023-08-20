package com.news.controller;

import com.news.model.Category;
import com.news.model.News;
import com.news.service.ICategoryService;
import com.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    INewsService iNewsService;
    @Autowired
    ICategoryService iCategoryService;
    @ModelAttribute("categories")
    public List<Category> categories(){
        return iCategoryService.getAll();
    }
    @GetMapping
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newses", iNewsService.getAll());
        return modelAndView;
    }
    @GetMapping("/admin")
    public ModelAndView getAllManager(){
        ModelAndView modelAndView = new ModelAndView("new-manager");
        modelAndView.addObject("newses", iNewsService.getAll());
        return modelAndView;
    }
    @GetMapping("/add")
    public ModelAndView showFormAdd(@ModelAttribute News news){
        ModelAndView modelAndView = new ModelAndView("add-News");
        modelAndView.addObject("news", news);
        return modelAndView;
    }
    @PostMapping("/add")
    public String AddNews(@ModelAttribute News news, @RequestParam int idCategory){
        iNewsService.save(news, idCategory);
        return "redirect:/news";
    }
    @GetMapping("/delete/{idNews}")
    public String delete(@PathVariable int idNews){
        iNewsService.delete(idNews);
        return "redirect:/news";
    }
}
