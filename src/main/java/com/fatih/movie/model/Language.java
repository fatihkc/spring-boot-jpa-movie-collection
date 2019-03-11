package com.fatih.movie.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "language_name")
    private String languageName;

    @Column(nullable = false)
    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Movie> movieSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
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
