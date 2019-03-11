package com.fatih.movie.repository;

import com.fatih.movie.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    Genre findByGenreName(String name);
}
