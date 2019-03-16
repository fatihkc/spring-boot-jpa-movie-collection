package com.fatih.movie.Repository;

import com.fatih.movie.model.Actor;
import com.fatih.movie.model.Movie;
import com.fatih.movie.repository.ActorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
//Testing the initial database which is configured in /resources/db.migration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ActorRepositoryTest {

    @Autowired
    private ActorRepository actorRepository;

    @Test
    public void TestfindByActorNameIn(){

        Movie movie = new Movie();
        Actor actor1 = new Actor();
        Actor actor2 = new Actor();

        Set<Actor> findByActorNameIn= actorRepository.findByActorNameIn(movie.getActor().stream().map(Actor::getActorName).collect(Collectors.toList()));
        findByActorNameIn.add(actor1);
        findByActorNameIn.add(actor2);
        movie.setActor(findByActorNameIn);
        //Initial database didn't used in here. Actors added one by one as you can see.
        assertThat(findByActorNameIn.stream().map(Actor::getActorName).collect(Collectors.toList())).hasSize(2);
    }
}

