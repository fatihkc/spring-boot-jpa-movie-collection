package com.fatih.movie.service;

import com.fatih.movie.model.Genre;
import com.fatih.movie.model.Movie;
import com.fatih.movie.model.Actor;
import com.fatih.movie.model.Language;
import com.fatih.movie.repository.LanguageRepository;
import com.fatih.movie.repository.ActorRepository;
import com.fatih.movie.repository.GenreRepository;
import com.fatih.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    private GenreRepository genreRepository;
    private ActorRepository actorRepository;
    private LanguageRepository languageRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository, ActorRepository actorRepository, LanguageRepository languageRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.actorRepository = actorRepository;
        this.languageRepository = languageRepository;
    }

    public Page<Movie> getAllMovie(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    public void saveMovie(Movie movie) {
        Genre genre = genreRepository.findByGenreName(movie.getGenre().getGenreName());
        movie.setGenre(genre);
        Set<Actor> actor= actorRepository.findByActorNameIn(movie.getActor().stream().map(Actor::getActorName).collect(Collectors.toList()));
        movie.setActor(actor);
        Language language = languageRepository.findByLanguageName(movie.getLanguage().getLanguageName());
        movie.setLanguage(language);
        movieRepository.save(movie);
    }

    public void deleteMovie(Integer id) {
        movieRepository.delete(id);
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findOne(id);
    }
}
