package com.fatih.movie.Service;

import com.fatih.movie.model.Actor;
import com.fatih.movie.model.Genre;
import com.fatih.movie.model.Movie;
import com.fatih.movie.model.Language;
import com.fatih.movie.repository.LanguageRepository;
import com.fatih.movie.repository.ActorRepository;
import com.fatih.movie.repository.GenreRepository;
import com.fatih.movie.repository.MovieRepository;
import com.fatih.movie.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private GenreRepository genreRepository;

    @Mock
    private ActorRepository actorRepository;

    @Mock
    private LanguageRepository languageRepository;

    @Test
    public void getMovieById() {
        MovieService movieService = new MovieService(movieRepository, genreRepository, actorRepository, languageRepository);
        Movie movie = new Movie();
        movie.setId(1);
        movie.setName("Test");
        movie.setDescription("TestDescription");
        movie.setMedia("TestMedia");
        movie.setStars("TestStars");
        Genre genre = new Genre();
        genre.setGenreName("TestGenre");
        movie.setGenre(genre);
        Language language = new Language();
        language.setLanguageName("TestLanguage");
        movie.setLanguage(language);
        Actor actor = new Actor();
        Set<Actor> actors = new HashSet<Actor>();
        actor.setActorName("TestActor");
        actor.setActorName("TestActor2");
        movie.setActor(actors);

        movieRepository.save(movie);

        when(movieRepository.findOne(1)).thenReturn(movie);

        Movie movie1 = movieService.getMovieById(1);
        assertThat(movie1).isEqualTo(movie);
    }
}
