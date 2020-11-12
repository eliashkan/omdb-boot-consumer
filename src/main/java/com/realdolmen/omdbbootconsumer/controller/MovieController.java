package com.realdolmen.omdbbootconsumer.controller;

import com.realdolmen.omdbbootconsumer.model.Movie;
import com.realdolmen.omdbbootconsumer.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @RequestMapping({"", "/"})
    public String movie(Model model) {

        Movie movie = movieService.getMovie();

        model.addAttribute("movie", movie);

        return "index";
    }
}
// localhost:8080/ - localhost:8080
