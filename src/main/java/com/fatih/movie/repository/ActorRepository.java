package com.fatih.movie.repository;

import com.fatih.movie.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    Set<Actor> findByActorNameIn(List<String> name);
}