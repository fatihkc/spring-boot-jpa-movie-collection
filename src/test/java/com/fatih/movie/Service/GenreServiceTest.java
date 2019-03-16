package com.fatih.movie.Service;

import com.fatih.movie.model.Genre;
import com.fatih.movie.repository.GenreRepository;
import com.fatih.movie.service.GenreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class GenreServiceTest {

    GenreService genreService;

    @Mock
    private GenreRepository genreRepository;


    @Test
    public void getAllGenre() throws Exception {
        Genre genre1 = new Genre();
        Genre genre2 = new Genre();
        genre1.setId(1);
        genre1.setGenreName("TestGenre1");
        genre2.setId(2);
        genre2.setGenreName("TestGenre2");


        when(genreRepository.findOne(1)).thenReturn(genre1);
        when(genreRepository.findOne(2)).thenReturn(genre2);

        assertThat(genre1.getGenreName()).hasToString("TestGenre1");
        assertThat(genre2.getGenreName()).hasToString("TestGenre2");
    }
}
