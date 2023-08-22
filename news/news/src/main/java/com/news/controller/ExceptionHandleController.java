package com.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandleController {
    @GetMapping("404")
    public String show404(){
        return "404";
    }
}
