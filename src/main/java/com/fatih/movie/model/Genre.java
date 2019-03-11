package com.fatih.movie.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "genre_name")
    private String genreName;

    @Column(nullable = false)
    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Movie> movieSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Set<Movie> getMovie() {
        return movieSet;
    }

    public void setMovie(Movie movie) {
        if (movieSet.size() == 0) {
            movieSet = new HashSet<>();
        }
        movieSet.add(movie);
    }
}
