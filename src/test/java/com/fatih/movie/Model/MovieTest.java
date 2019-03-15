package com.fatih.movie.Model;

import com.fatih.movie.model.Actor;
import com.fatih.movie.model.Genre;
import com.fatih.movie.model.Language;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.fatih.movie.model.Movie;
import java.util.HashSet;
import java.util.Set;

public class MovieTest {

    @Test
    public void IdGetterSetter() {
        Movie movie = new Movie();
        movie.setId(1);
        assertThat(movie.getId()).isEqualTo(1);
    }

    @Test
    public void NameGetterSetter() {
       Movie movie = new Movie();
       movie.setName("TestMovie");
       assertThat(movie.getName()).isEqualTo("TestMovie");
   }

   @Test
    public void YearGetterSetter() {
       Movie movie = new Movie();
       movie.setYear(2019);
       assertThat(movie.getYear()).isEqualTo(2019);
   }

   @Test
    public void DescriptionGetterSetter() {
        Movie movie = new Movie();
        movie.setDescription("TestDescription");
        assertThat(movie.getDescription()).isEqualTo("TestDescription");
   }

   @Test
    public void MediaGetterSetter(){
        Movie movie = new Movie();
        movie.setMedia("TestMedia");
        assertThat(movie.getMedia()).isEqualTo("TestMedia");
   }

   @Test
    public void StarsGetterSetter(){
        Movie movie = new Movie();
        movie.setStars("TestStars");
        assertThat(movie.getStars()).isEqualTo("TestStars");
   }

   @Test
    public void GenreGetterSetter(){
        Movie movie = new Movie();
        Genre genre = new Genre();
        movie.setGenre(genre);
        assertThat(movie.getGenre()).isEqualTo(genre);
   }

   @Test
    public void LanguageGetterSetter(){
        Movie movie = new Movie();
        Language language = new Language();
        movie.setLanguage(language);
        assertThat(movie.getLanguage()).isEqualTo(language);
   }

   @Test
    public void ActorGetterSetter(){
        Movie movie = new Movie();
        Set<Actor> actor = new HashSet<>();
        movie.setActor(actor);
        assertThat(movie.getActor()).isEqualTo(actor);
   }
}
