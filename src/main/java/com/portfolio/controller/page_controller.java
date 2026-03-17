package com.portfolio.controller;

import com.portfolio.leetcode.LeetCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class page_controller {

    @Autowired
    private LeetCodeService leetCodeService;

    @RequestMapping(value = "/")
    public String redirect() {
        return "forward:/ironman112/home";
    }

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
    public String showContactPage(Model model) {

        return "Skills";
    }
}
