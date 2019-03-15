package com.fatih.movie.Model;

import com.fatih.movie.model.Language;
import com.fatih.movie.model.Movie;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LanguageTest {

    @Test
    public void IdGetterSetter() {
        Language language = new Language();
        language.setId(1);
        assertThat(language.getId()).isEqualTo(1);

    }

    @Test
    public void NameGetterSetter(){
        Language language = new Language();
        language.setLanguageName("TestLanguageName");
        assertThat(language.getLanguageName()).isEqualTo("TestLanguageName");
    }

    @Test
    public void MovieGetterSetter(){

        Language language = new Language();
        Movie movie = new Movie();
        Set<Movie> movieSet = new HashSet<>();
        movieSet.add(movie);
        language.setMovie(movie);
        assertThat(language.getMovie()).isEqualTo(movieSet);
    }
}
