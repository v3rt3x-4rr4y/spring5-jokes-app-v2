package com.jukka.spring5jokesappv2.controllers;

import com.jukka.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController
{
    private final JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService)
    {
        this.jokeService = jokeService;
    }

    // Maps the base URL ("http://mysite.com/" or "http://mysite.com") to this controller method
    @RequestMapping({"/", ""})
    public String showJoke(Model model)
    {
        model.addAttribute("joke", jokeService.getJoke());
        return "index";
    }
}
