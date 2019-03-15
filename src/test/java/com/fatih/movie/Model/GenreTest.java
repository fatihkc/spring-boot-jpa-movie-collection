package com.fatih.movie.Model;

import com.fatih.movie.model.Genre;
import com.fatih.movie.model.Movie;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GenreTest {

    @Test
    public void IdGetterSetter() {
        Genre genre = new Genre();
        genre.setId(1);
        assertThat(genre.getId()).isEqualTo(1);

    }

    @Test
    public void NameGetterSetter(){
        Genre genre = new Genre();
        genre.setGenreName("TestGenreName");
        assertThat(genre.getGenreName()).isEqualTo("TestGenreName");
    }

    @Test
    public void MovieGetterSetter(){

        Genre genre = new Genre();
        Movie movie = new Movie();
        Set<Movie> movieSet = new HashSet<>();
        movieSet.add(movie);
        genre.setMovie(movie);
        assertThat(genre.getMovie()).isEqualTo(movieSet);

    }
}
