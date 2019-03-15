package com.fatih.movie.Model;

import com.fatih.movie.model.Actor;
import com.fatih.movie.model.Movie;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ActorTest {

    @Test
    public void IdGetterSetter() {
        Actor actor = new Actor();
        actor.setId(1);
        assertThat(actor.getId()).isEqualTo(1);

    }

    @Test
    public void NameGetterSetter(){
        Actor actor = new Actor();
        actor.setActorName("TestActorName");
        assertThat(actor.getActorName()).isEqualTo("TestActorName");
    }

    @Test
    public void MovieGetterSetter(){

        Actor actor = new Actor();
        Movie movie = new Movie();
        Set<Movie> movieSet = new HashSet<>();
        movieSet.add(movie);
        actor.setMovie(movieSet);
        assertThat(actor.getMovie()).isEqualTo(movieSet);

    }
}
