package com.news.controller;

import com.news.model.Category;
import com.news.model.News;
import com.news.model.User;
import com.news.service.ICategoryService;
import com.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.GroupSequence;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    INewsService iNewsService;
    @Autowired
    ICategoryService iCategoryService;
    @Autowired
    HttpSession session;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return iCategoryService.getAll();
    }

    @ModelAttribute("user")
    public User user() {
        return (User) session.getAttribute("user");
    }

    @GetMapping
    public ModelAndView getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String titleSearch) {
        ModelAndView modelAndView = new ModelAndView("index");
        Page<News> news = iNewsService.getAllByTitle(titleSearch, PageRequest.of(page, 7, Sort.by("idNews")));
        modelAndView.addObject("newses", news);
        return modelAndView;
    }
//    @GetMapping
//    public ModelAndView getAll() {
//        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("newses", iNewsService.getAll());
//        return modelAndView;
//    }

    @GetMapping("/blog/{idNews}")
    public ModelAndView showBlog(@PathVariable int idNews) {
        ModelAndView modelAndView = new ModelAndView("single-standard");
        modelAndView.addObject("newses", iNewsService.findById(idNews));
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView getAllManager() {
        User user = (User) session.getAttribute("user");
        if (user.getRole().equals("admin")) {
            ModelAndView modelAndView = new ModelAndView("new-manager");
            modelAndView.addObject("newses", iNewsService.getAll());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/news");
            return modelAndView;
        }
    }

    @GetMapping("/add")
    public ModelAndView showFormAdd(@ModelAttribute News news) {
        ModelAndView modelAndView = new ModelAndView("add-News");
        modelAndView.addObject("news", news);
        return modelAndView;
    }

    @PostMapping("/add")
    public String AddNews(@ModelAttribute News news, @RequestParam int idCategory) {
        iNewsService.save(news, idCategory);
        return "redirect:/news/admin";
    }

    @GetMapping("/delete/{idNews}")
    public String delete(@PathVariable int idNews) {
        iNewsService.delete(idNews);
        return "redirect:/news/admin";
    }

    @GetMapping("/edit/{idNews}")
    public ModelAndView showFormEdit(@PathVariable int idNews) {
        ModelAndView modelAndView = new ModelAndView("edit-News");
        modelAndView.addObject("news", iNewsService.findById(idNews));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String showFormEdit(@ModelAttribute News news, @RequestParam int idCategory) {
        iNewsService.save(news, idCategory);
        return "redirect:/news/admin";
    }

    @GetMapping("/category/{idCategory}")
    public ModelAndView getAll(@PathVariable int idCategory) {
        ModelAndView modelAndView = new ModelAndView("category");
        List<News> news = iNewsService.getAllByCategoryId(idCategory);
        modelAndView.addObject("category", iCategoryService.findById(idCategory));
        modelAndView.addObject("newses", news);
        return modelAndView;
    }
}
