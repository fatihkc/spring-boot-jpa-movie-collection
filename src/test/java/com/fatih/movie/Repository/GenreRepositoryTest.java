package com.fatih.movie.Repository;

import com.fatih.movie.model.Genre;
import com.fatih.movie.repository.GenreRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
//Testing the initial database which is configured in /resources/db.migration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void TestfindByGenreName(){

        Genre genre = new Genre();
        genre.setId(1);
        Genre findByGenreName = genreRepository.findOne(genre.getId());
        //In database we already have an genre with id=1 and genreName=Comedy
        assertThat(findByGenreName).hasFieldOrPropertyWithValue("genreName","Comedy");
    }
}
