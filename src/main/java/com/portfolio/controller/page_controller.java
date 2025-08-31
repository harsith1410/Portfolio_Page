package com.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ironman112")
public class page_controller {

    @GetMapping("/home")
    public String ironman112() {
        return "home";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    @GetMapping("/projects")
    public String projects() {
        return "Projects";
    }
    @GetMapping("/skills")
    public String skills() {
        return "Skills";
    }


}
