package com.fatih.movie.controller;

import com.fatih.movie.model.Genre;
import com.fatih.movie.model.Movie;
import com.fatih.movie.model.Actor;
import com.fatih.movie.model.Language;
import com.fatih.movie.service.LanguageService;
import com.fatih.movie.service.ActorService;
import com.fatih.movie.service.GenreService;
import com.fatih.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/movies")
public class MainController {

    private MovieService movieService;
    private GenreService genreService;
    private ActorService actorService;
    private LanguageService languageService;

    private static int currentPage = 1;
    private static int pageSize = 5;

    @Autowired
    public MainController(MovieService movieService, GenreService genreService, ActorService actorService, LanguageService languageService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.actorService = actorService;
        this.languageService = languageService;
    }

    @RequestMapping("")
    public String index(Model model, @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {
        page.ifPresent(p -> currentPage = p);
        size.ifPresent(s -> pageSize = s);

        Pageable pageable = new PageRequest(currentPage - 1, pageSize);
        Page<Movie> moviePage = movieService.getAllMovie(pageable);

        model.addAttribute("moviePage", moviePage);

        int totalPages = moviePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "movies";
    }


    @RequestMapping(value = "/add")
    public String addMovie(@Valid Model model) {
        List<Genre> genreList = genreService.getAllGenre();
        List<Actor> actorList = actorService.getAllActor();
        List<Language> languageList = languageService.getAllLanguage();
        model.addAttribute("movie", new Movie());
        model.addAttribute("genreList", genreList);
        model.addAttribute("actorList",actorList);
        model.addAttribute("languageList",languageList);

        return "addmovie";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Movie movie) {
        movieService.saveMovie(movie);

        return "redirect:/movies";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteMovie(@PathVariable("id") Integer id) {
        movieService.deleteMovie(id);

        return "redirect:/movies";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editMovie(@PathVariable("id") Integer id, Model model) {
        Movie movie = movieService.getMovieById(id);
        List<Genre> genreList = genreService.getAllGenre();
        List<Actor> actorList = actorService.getAllActor();
        List<Language> languageList = languageService.getAllLanguage();
        model.addAttribute("movie", movie);
        model.addAttribute("genreList", genreList);
        model.addAttribute("actorList", actorList);
        model.addAttribute("languageList", languageList);

        return "editmovie";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handlerException() {
        return "error/404";
    }
}
