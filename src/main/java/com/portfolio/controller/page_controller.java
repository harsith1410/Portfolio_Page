package com.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class page_controller {

    @GetMapping("/ironman112/home")
    public String ironman112() {
        return "home";
    }


    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }


    @GetMapping("/projects")
    public String showProjectsPage() {
        return "Projects";
    }


    @GetMapping("/skills")
    public String showContactPage() {
        return "Skills";
    }
}
