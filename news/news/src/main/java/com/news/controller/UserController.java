package com.news.controller;

import com.news.model.User;
import com.news.service.IUserService;
import com.news.service.impl.IUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;
    @Autowired
    HttpSession session;

    @GetMapping("/login")
    public String showFormLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        User user = iUserService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            if (user.getRole().equals("user")) {
                return "redirect:/news";
            }else if (user.getRole().equals("admin")) {
                return "redirect:/news/admin";
            }
        }
            return "redirect:/user/login";

    }
}
