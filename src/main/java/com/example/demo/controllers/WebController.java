package com.example.demo.controllers;

import com.example.demo.services.CandyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Rest controller bean.
 * @author Conor O
 * @version 1
 */
@Controller
public class WebController
{
    // need access to service
    // use dependency injection to access our service
    private CandyService service;

    public WebController(CandyService service)
    {
        this.service = service;
    }

    // the methods below will define a route to a page
    // string returned is name of page
    // public String foo() {}

    // localhost:8081/home
    @RequestMapping("home")
    public String getHomePage()
    {
        // the name of the view in the templates directory
        // matches what is in templates directory (minus .html or whatever, although that could be added)
        return "home";
    }

    //localhost:8081/favorite
    @RequestMapping("favorite")
    public String getFaveCandy(Model model)
    {
        model.addAttribute("title", "My Fave Candy");
        model.addAttribute("favorite", service.getFavorite());
        return "favorite_candy";
    }
}
